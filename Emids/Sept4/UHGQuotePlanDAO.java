package com.connecture.uhg.sgquoting.products;

import static org.apache.commons.collections.CollectionUtils.isNotEmpty;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import com.connecture.exemplar.planservice.ProductData;
import com.connecture.exemplar.quote.QuotePlanRider;
import com.connecture.uhg.jdbc.UHGPlanDAO;
import com.connecture.uhg.jdbc.UHGRiderDAO;
import com.connecture.uhg.process.common.UHGConstants;
import com.connecture.uhg.sgquoting.UHGSelectedRidersRateProcess;
import com.connecture.uhg.sgquoting.products.benefits.UHGQuoteExternalPlanBenefitExtProcess;
import com.connecture.uhg.sgquoting.proposal.aspose.words.UhgAsposeWordsProposalOutputBuilderUtility.ProductLines;
import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.rwsol.exemplar.process.common.UnexpectedProcessException;
import com.rwsol.exemplar.process.productselection.ExternalQuotePlanPersistence;
import com.rwsol.exemplar.process.productselection.ProductQuotePlanDAO;
import com.rwsol.exemplar.process.productselection.QuoteExternalPlanDetailsInfo;
import com.rwsol.exemplar.process.productselection.QuoteExternalPlansDetailsProcess;
import com.rwsol.exemplar.process.productselection.QuotePlan;
import com.rwsol.exemplar.process.productselection.QuotePlanInfo;
import com.rwsol.exemplar.process.productselection.QuotePlanPersistenceStrategy;
import com.rwsol.exemplar.process.productselection.QuotePlanProcessException;
import com.rwsol.exemplar.process.productselection.UHGQuotePlan;
import com.rwsol.exemplar.process.productselection.UnavailablePlan;
import com.rwsol.exemplar.process.productselection.planoffering.PlanOfferingData;
import com.rwsol.exemplar.process.productselection.planoffering.PlanOfferingProcess;
import com.rwsol.exemplar.process.productselection.planoffering.PlanOfferingType;
import com.rwsol.exemplar.process.sgquoting.data.SGQuotePlanData;
import com.rwsol.exemplar.process.sgquoting.product.ProductLineProcess;
import com.rwsol.exemplar.process.sgrating.SgRateEngine;
import com.rwsol.exemplar.process.sgrating.domain.output.PlanRateDetail;
import com.rwsol.exemplar.process.sgrating.domain.output.RiderRateDetail;
import com.rwsol.exemplar.process.sgrating.exception.SGRatingException;
import com.rwsol.express.components.quote.api.QuotePackageData;
import com.rwsol.express.components.quote.api.QuotePackageTypeData;
import com.rwsol.syb.system.CreationException;
import com.rwsol.syb.system.SystemServices;

public class UHGQuotePlanDAO extends ProductQuotePlanDAO
{
   @Autowired
  private SessionFactory sessionFactory;
  @Autowired
  private UHGPlanDAO uhgPlanDAO;
  private UHGRiderDAO uhgRiderDAO;
  private UHGQuoteExternalPlanBenefitExtProcess uhgPlanBenefitExtProcess;
  private UHGSelectedRidersRateProcess uhgSelectedRidersRateProcess;
  private QuotePlanPersistenceStrategy externalQuotePlanPersistenceStrategy;
  private ProductLineProcess productLineProcess;
  private QuoteExternalPlansDetailsProcess quoteExternalPlansDetailsProcess;
  @Autowired
  private PlanOfferingProcess planOfferingProcess;
  private static final Logger LOG = Logger.getLogger(UHGQuotePlanDAO.class);

  public List<SGQuotePlanData> savePlanGroup(
      long quoteId,
      List<String> planIds,
      long subGroupId,
      String planGroupId,
      Multimap<String, String> planIdToMetalTierMap)
  {
    Map<String, Long> mappedQuotePackageIds = createMappedQuotePackageIds(quoteId, planIdToMetalTierMap);
    saveAllPlanOfferingInfo(subGroupId, mappedQuotePackageIds, PlanOfferingType.GROUP);

    return createQuoteGroupPlans(quoteId, subGroupId, planIds, mappedQuotePackageIds, planGroupId);
  }

  @Override
  public List<UnavailablePlan> checkSelectedPlansAvailability(long quoteId)
  {
    List<UnavailablePlan> unavailablePlans = new ArrayList<>();
    List<QuotePlanInfo> selectedQuotePlans = retrieveAllQuotePlans(quoteId);

    if (isNotEmpty(selectedQuotePlans))
    {
      List<String> selectedProductLines = productLineProcess.getSelectedProductLines(quoteId);
      if (isNotEmpty(selectedProductLines)
          && selectedProductLines.contains(UHGConstants.PRODUCT_LINE_CODES.LIFE_AD_D_PRODUCTLINE_CODE))
      {
        selectedProductLines.add(ProductLines.DEPENDENT_LIFE.getProductLineCode());
        selectedProductLines.add(ProductLines.SUPPLEMENTAL_DEPENDENT_LIFE.getProductLineCode());
        selectedProductLines.add(ProductLines.SUPPLEMENTAL_LIFE.getProductLineCode());
      }
      for (QuotePlanInfo selectedQuotePlan : selectedQuotePlans)
      {
        String productLineCode = retrieveProductLine(selectedQuotePlan);
        if (productLineCode == null || !selectedProductLines.contains(productLineCode))
        {
          UnavailablePlan unavailablePlan = createUnavailablePlan(selectedQuotePlan);
          unavailablePlans.add(unavailablePlan);
        }
      }
    }

    return unavailablePlans;
  }

  @Override
  public void deleteUnavailablePlans(List<UnavailablePlan> unavailablePlans)
  {

    /*
     * A no-op for UHG. We have coded ourself into a corner here by not putting
     * all the delete quote plan operations in the process layer. Because of
     * this the best course of action for uhg is to do nothing here and then
     * call to quote plan action to delete. This way when the quote plan action
     * extensions change we don't need to make the same changes here.
     */

  }

  private UnavailablePlan createUnavailablePlan(QuotePlanInfo selectedQuotePlan)
  {

    UnavailablePlan unavailablePlan = new UnavailablePlan();

    unavailablePlan.setQuotePlanId(selectedQuotePlan.getQuotePlanId());
    unavailablePlan.setQuotePackageId(selectedQuotePlan.getQuotePackageId());
    unavailablePlan.setPlanId(selectedQuotePlan.getPlanId());
    unavailablePlan.setName(selectedQuotePlan.getName());

    return unavailablePlan;
  }

  public String retrieveProductLine(QuotePlanInfo selectedQuotePlan)
  {

    String productLineId = null;

    long quotePlanId = selectedQuotePlan.getQuotePlanId();

    QuoteExternalPlanDetailsInfo quotePlanDetails = quoteExternalPlansDetailsProcess
        .findQuoteExternalPlanDetail(quotePlanId);

    if (quotePlanDetails != null)
    {
      ProductLines productLine = ProductLines.getProductLineFromName(quotePlanDetails.getProductLine());
      String productLineCode = productLine.getProductLineCode();
      if (!StringUtils.isEmpty(productLineCode))
      {
        productLineId = productLineCode;
      }
    }

    return productLineId;
  }

  protected PlanOfferingData savePlanOfferingInfo(long subGroupId, long quotePackageId, PlanOfferingType type)
  {
    PlanOfferingData planOfferingInfo = new PlanOfferingData();
    planOfferingInfo.setSubgroupId(subGroupId);
    planOfferingInfo.setQuotePackageId(quotePackageId);
    // Plan offering name doesn't seem to be used
    planOfferingInfo.setName(null);
    planOfferingInfo.setType(type);

    return planOfferingInfo;
  }

  public long savePlan(
      long quoteId,
      String planId,
      long subGroupId,
      String planGroupId,
      String planNickName,
      List<String> selectedRiders,
      PlanOfferingType type)
  {
    long quotePackageId = createQuotePackage(quoteId);
    long quotePlanId = createQuotePlan(quoteId, subGroupId, planId, quotePackageId, planGroupId, planNickName,
        selectedRiders, null);
    planOfferingProcess.save(savePlanOfferingInfo(subGroupId, quotePackageId, type));
    return quotePlanId;
  }

  /**
   * Returns {@link List} of {@link QuotePlanInfo} for quoteId
   * <p>
   * If planId is blank or "null" planId is set to planName
   * <p>
   * planId is required else correct data cannot be pulled from OISABIT Plans
   * 
   * @param quoteId
   */
  public List<QuotePlanInfo> getAllQuotePlansWithPlanId(long quoteId)
  {
    List<QuotePlanInfo> allQuotePlans = externalQuotePlanPersistenceStrategy.findAllQuotePlans(quoteId);
    for (QuotePlanInfo each : allQuotePlans)
    {
      if (StringUtils.isBlank(each.getPlanId()) || "null".equalsIgnoreCase(each.getPlanId()))
      {
        each.setPlanId(each.getName());
      }
    }
    return allQuotePlans;
  }

  public Set<Long> getQuotePlanIdsWithSameQuotePackageId(long quotePlanId)
  {
    QuotePlan quotePlanInfo = externalQuotePlanPersistenceStrategy.findQuotePlan(quotePlanId);

    List<QuotePlanInfo> allQuotePlans = externalQuotePlanPersistenceStrategy
        .findQuotePlanInfosByQuotePackageId(quotePlanInfo.getQuotePackageId());
    Function<QuotePlanInfo, Long> function = new Function<QuotePlanInfo, Long>()
    {
      @Override
      public Long apply(QuotePlanInfo info)
      {
        return info.getQuotePlanId();
      }
    };
    return FluentIterable.from(allQuotePlans).transform(function).toSet();
  }

  /**
   * @param quoteId
   * @param planIds
   * @param planIdToMetalTierMap
   * @return
   * @throws QuotePlanProcessException
   */
  private Map<String, Long> createMappedQuotePackageIds(long quoteId, Multimap<String, String> planIdToMetalTierMap)
  {
    Map<String, Long> mappedQuotePkgIds = new HashMap<>();
    if (planIdToMetalTierMap != null && planIdToMetalTierMap.size() > 0)
    {
      try
      {
        int maxSortOrder = 0;
        QuotePackageData[] qPkgs = getQuote().findPackagesForQuote(quoteId, getCtx());
        for (int i = 0; i < qPkgs.length; i++)
        {
          maxSortOrder = Math.max(qPkgs[i].getSortOrder(), maxSortOrder);
        }
        for (String planId : planIdToMetalTierMap.keySet())
        {
          for (String tier : planIdToMetalTierMap.get(planId))
          {

            maxSortOrder++;
            long quotePackageId = getAvailablePlanScreenProcess().createPackage(quoteId, maxSortOrder,
                QuotePackageTypeData.ALTERNATE);
            mappedQuotePkgIds.put(planId + "," + tier, quotePackageId);
          }
        }
      }
      catch (Exception e)
      {
        throw new QuotePlanProcessException("Unable to create quote package", e);
      }
    }
    return mappedQuotePkgIds;
  }

  /**
   * @param subGroupId
   * @param mappedQuotePkgIds
   */
  private void saveAllPlanOfferingInfo(long subGroupId, Map<String, Long> mappedQuotePkgIds, PlanOfferingType type)
  {
    if (MapUtils.isNotEmpty(mappedQuotePkgIds))
    {
      List<PlanOfferingData> planOfferingInfoList = new ArrayList<>();

      mappedQuotePkgIds.forEach(
          (name, quotePackageId) -> planOfferingInfoList.add(savePlanOfferingInfo(subGroupId, quotePackageId, type)));

      if (CollectionUtils.isNotEmpty(planOfferingInfoList))
      {
        planOfferingProcess.save(planOfferingInfoList);
      }
    }
  }

  @Override
  public SGQuotePlanData.BenefitOption readConfiguredPlan(
      long quoteId,
      Long planId,
      long subGroupId,
      Long planGroupId,
      String planNickName)
  {
    SGQuotePlanData.BenefitOption benefitOption = new SGQuotePlanData.BenefitOption();
    if (super.getQuotePlanPersistenceStrategy() instanceof ExternalQuotePlanPersistence)
    {
      benefitOption.setBenefitId(((ExternalQuotePlanPersistence) super.getQuotePlanPersistenceStrategy())
          .readConfiguredPlan(planId).getExternalBenefitKey());
      benefitOption.setBenefitValueSetId(((ExternalQuotePlanPersistence) super.getQuotePlanPersistenceStrategy())
          .readConfiguredPlan(planId).getExternalBenefitValue());
    }
    return benefitOption;
  }

  private long createQuotePlan(
      long quoteId,
      long subgroupId,
      String planId,
      long quotePackageId,
      String planGroupId,
      String planNickName,
      List<String> selectedRiders,
      Plan plan)
  {
    try
    {
      QuotePlanInfo quotePlanInfo = getQuotePlanPersistenceStrategy().createQuotePlanData(quoteId, subgroupId, planId,
          planId, quotePackageId, null, planGroupId, planNickName);
      long quotePlanId = quotePlanInfo.getQuotePlanId();
      if (!CollectionUtils.isEmpty(selectedRiders))
      {
        LOG.info("Riders found- Processing riders");
        Plan productData = plan;
        if (null == productData)
        {
          productData = uhgPlanDAO.findUHGPlanByPlanCode(quoteId, planId);
        }
        Long oisabitId = productData.getOisabitId();
        if (oisabitId == null || oisabitId == 0)
        {
          oisabitId = uhgPlanDAO.retrieveOisabitForPlan(productData.getId());
        }
        // converting UHG-rider to planservice Rider
        List<com.connecture.exemplar.planservice.Rider> planRiderList = new LinkedList<>();
        if (productData.getRiders() != null)
        {
          for (Rider rider : productData.getRiders())
          {
            com.connecture.exemplar.planservice.Rider planRider = new com.connecture.exemplar.planservice.Rider();
            planRider.setExternalCode(rider.getRiderCode());
            // finding description of rider
            OptionalRider riderDetail = uhgRiderDAO.findRiderDetail(rider.getRiderCode(), oisabitId);
            if (riderDetail != null)
            {
              planRider.setRiderName(riderDetail.getRiderDescription());
              planRiderList.add(planRider);
            }
          }
        }
        super.getQuotePlanPersistenceStrategy().saveSelectedPlanRiders(quotePlanId, selectedRiders, planRiderList);
        PlanRateDetail planRateDetail = getPlanRateDetail(quoteId, planId, subgroupId);
        if (planRateDetail != null)
        {
          saveRidersRate(quotePlanId, planRateDetail);
        }
      }
      // updateBenefits(quotePlanId, productData, configOptions);//TODO:
      // We arent using this currently? Do we need to?
      return quotePlanId;
    }
    catch (Exception e)
    {
      throw new QuotePlanProcessException("Unable to create quote plan", e);
    }
  }

  /**
   * @param quoteId
   * @param subgroupId
   * @param planIds
   * @param mappedQuotePackageIds
   * @param planGroupId
   * @return
   * @throws QuotePlanProcessException
   */
  private List<SGQuotePlanData> createQuoteGroupPlans(
      long quoteId,
      long subgroupId,
      List<String> planIds,
      Map<String, Long> mappedQuotePackageIds,
      String planGroupId)
  {
    List<SGQuotePlanData> quotePlanInfoList = null;
    try
    {
      if (CollectionUtils.isNotEmpty(planIds) && MapUtils.isNotEmpty(mappedQuotePackageIds))
      {
        quotePlanInfoList = createQuotePlanDataList(quoteId, subgroupId, planGroupId, mappedQuotePackageIds);
      }
    }
    catch (Exception e)
    {
      throw new QuotePlanProcessException("Unable to create quote plan", e);
    }
    return quotePlanInfoList;
  }

  /***
   * @param quotePlanIdList
   ***/
  public List<QuotePlan> findQuotePlanListByQuotePlanIdList(List<Long> quotePlanIdList)
  {
    Session session = this.sessionFactory.getCurrentSession();
    String hqlQuery = "from QuotePlan as quotePlan where quotePlan.quotePlanId in (:quotePlanId)";
    return (List<QuotePlan>) session.createQuery(hqlQuery).setParameterList("quotePlanId", quotePlanIdList).list();
  }

  /***
   * @param quotePackageIdList
   ***/
  public List<QuotePlan> findQuotePlanListByQuotePackageIdList(List<Long> quotePackageIdList)
  {
    Session session = sessionFactory.getCurrentSession();
    String hqlQuery = "from QuotePlan as quotePlan where quotePlan.quotePackageId in (:quotePackageId)";
    return (List<QuotePlan>) session.createQuery(hqlQuery).setParameterList("quotePackageId", quotePackageIdList)
        .list();
  }

  /**
   * @param quoteId
   * @param subgroupId
   * @param planGroupId
   * @param mappedQuotePackageIds
   * @return
   */
  public List<SGQuotePlanData> createQuotePlanDataList(
      long quoteId,
      long subgroupId,
      String planGroupId,
      Map<String, Long> mappedQuotePackageIds)
  {
    Map<String, QuotePlan> quotePlanMap = Maps.newHashMap();
    QuotePlan quotePlan = null;
    for (Entry<String, Long> entry : mappedQuotePackageIds.entrySet())
    {
      String planId = entry.getKey().split(",")[0];
      Long quotePkgId = entry.getValue();
      quotePlan = new QuotePlan();
      quotePlan.setExternalPlanId(planId);
      quotePlan.setName(planId);
      quotePlan.setQuoteId(quoteId);
      quotePlan.setQuotePackageId(quotePkgId);
      if (subgroupId > 0)
      {
        quotePlan.setSubgroupId(subgroupId);
      }
      Date version = new Date();
      quotePlan.setVersion(version);
      quotePlan.setExternalPlanFamilyKey(planGroupId);
      quotePlan.setPackageProductLineId(null);
      quotePlanMap.put(entry.getKey(), quotePlan);
    }
    return uhgPlanDAO.saveQuotePlanDataList(quotePlanMap);
  }

  public List<QuotePlan> findQuotePlans(Long[] quotePlanIds)
  {
    return sessionFactory.getCurrentSession()
        .createQuery("FROM QuotePlan plan WHERE plan.quotePlanId IN (:quotePlanIds)")
        .setParameterList("quotePlanIds", quotePlanIds).list();
  }

  public List<Long> findQuotePlanIds(Long quoteId, List<String> quotePlanNames)
  {
    String query = "SELECT plan.quotePlanId FROM QuotePlan plan WHERE plan.quoteId = :quoteId AND plan.name IN (:quotePlanNames)";
    return sessionFactory.getCurrentSession().createQuery(query).setLong("quoteId", quoteId)
        .setParameterList("quotePlanNames", quotePlanNames).list();
  }

  public List<QuotePlan> findQuotePlansByPlanNames(Long quoteId, List<String> planNames)
  {
    return sessionFactory.getCurrentSession()
        .createQuery("FROM QuotePlan plan WHERE plan.quoteId = :quoteId AND plan.name IN  (:planNames)")
        .setLong("quoteId", quoteId).setParameterList("planNames", planNames).list();
  }
  
  public List<QuotePlan> fetchUnselectedQuotePlan(List<Long> planIdList, Long quoteId)
  {
	  Session currSession = sessionFactory.getCurrentSession();
	  Criteria crit = currSession.createCriteria(UHGQuotePlan.class);
	  
	  crit.add(Restrictions.and(Restrictions.in("quotePlanId", planIdList), Restrictions.eq("quoteId", quoteId)));
	  return crit.list();
  }

  public void removeUnselectedQuotePlan(List<QuotePlan> unSelectedPlan)
  {
	  
	  for(QuotePlan plan: unSelectedPlan)
	  {  
		  sessionFactory.getCurrentSession().delete(plan);
	  }
	  
  }
  
  public UHGRiderDAO getUhgRiderDAO()
  {
    return uhgRiderDAO;
  }

  public void setUhgRiderDAO(UHGRiderDAO uhgRiderDAO)
  {
    this.uhgRiderDAO = uhgRiderDAO;
  }

  /**
   * @param quoteId
   * @param planId
   * @param subgroupId
   * @return
   */
  public PlanRateDetail getPlanRateDetail(long quoteId, String planId, long subgroupId)
  {
    List<PlanRateDetail> planRateDetails = null;
    ProductData productData = new ProductData();
    Map<String, Object> customMap = new HashMap<>();
    productData.setExternalCode(planId);
    productData.setId(planId);
    productData.setInternalCode(planId);
    productData.setSubgroupId(subgroupId);
    List<ProductData> products = new ArrayList<>();
    products.add(productData);
    try
    {
      SgRateEngine sgRateEngine = (SgRateEngine) SystemServices.createComponent(getClass().getName(), "sgRateEngine");
      planRateDetails = sgRateEngine.anonymousCalculate(quoteId, subgroupId, products, customMap);
    }
    catch (SGRatingException e)
    {
      throw new UnexpectedProcessException("SGRatingException is caught in UHGQuotePlanDAO.java", e);
    }
    catch (CreationException e)
    {
      throw new UnexpectedProcessException("Error while creation of bean sgRateEngine", e);
    }
    if (isNotEmpty(planRateDetails))
    {
      return planRateDetails.get(0);
    }
    else
    {
      return null;
    }
  }

  /**
   * @param quotePlanId
   * @param planRateDetail
   */
  public void saveRidersRate(long quotePlanId, PlanRateDetail planRateDetail)
  {
    List<Long> quotePlanIds = new ArrayList<>();
    quotePlanIds.add(quotePlanId);
    List<RiderRateDetail> riderRateDetails = planRateDetail.getRiderRateDetails();
    List<QuotePlanRider> quotePlanRiders = super.getQuotePlanPersistenceStrategy().findAllSavedPlanRiders(quotePlanIds);
    if (isNotEmpty(quotePlanRiders) && isNotEmpty(riderRateDetails))
    {
      for (QuotePlanRider quotePlanRider : quotePlanRiders)
      {
        if (quotePlanRider.getQuotePlanId() == quotePlanId)
        {
          for (RiderRateDetail riderRateDetail : riderRateDetails)
          {
            if (quotePlanRider.getExternalRiderId().equalsIgnoreCase(riderRateDetail.getPlanId()))
            {
              uhgSelectedRidersRateProcess.saveOptionalPlanRiderRateAmount(riderRateDetail.getRate(), quotePlanId,
                  quotePlanRider.getQuotePlanRiderId());
            }
          }
        }
      }
    }
  }

  public UHGSelectedRidersRateProcess getUhgSelectedRidersRateProcess()
  {
    return uhgSelectedRidersRateProcess;
  }

  public void setUhgSelectedRidersRateProcess(UHGSelectedRidersRateProcess uhgSelectedRidersRateProcess)
  {
    this.uhgSelectedRidersRateProcess = uhgSelectedRidersRateProcess;
  }

  public UHGQuoteExternalPlanBenefitExtProcess getUhgPlanBenefitExtProcess()
  {
    return uhgPlanBenefitExtProcess;
  }

  public void setUhgPlanBenefitExtProcess(UHGQuoteExternalPlanBenefitExtProcess uhgPlanBenefitExtProcess)
  {
    this.uhgPlanBenefitExtProcess = uhgPlanBenefitExtProcess;
  }

  public QuotePlanPersistenceStrategy getExternalQuotePlanPersistenceStrategy()
  {
    return externalQuotePlanPersistenceStrategy;
  }

  public void setExternalQuotePlanPersistenceStrategy(QuotePlanPersistenceStrategy externalQuotePlanPersistenceStrategy)
  {
    this.externalQuotePlanPersistenceStrategy = externalQuotePlanPersistenceStrategy;
  }

  public ProductLineProcess getProductLineProcess()
  {
    return productLineProcess;
  }

  public void setProductLineProcess(ProductLineProcess productLineProcess)
  {
    this.productLineProcess = productLineProcess;
  }

  public QuoteExternalPlansDetailsProcess getQuoteExternalPlansDetailsProcess()
  {
    return quoteExternalPlansDetailsProcess;
  }

  public void setQuoteExternalPlansDetailsProcess(QuoteExternalPlansDetailsProcess quoteExternalPlansDetailsProcess)
  {
    this.quoteExternalPlansDetailsProcess = quoteExternalPlansDetailsProcess;
  }

}

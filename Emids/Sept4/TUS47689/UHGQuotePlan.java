package com.rwsol.exemplar.process.productselection;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.connecture.uhg.UHGQuotePlanExt;
import com.connecture.uhg.sgquoting.products.UHGQuotePlanExternalInfo;
import com.connecture.uhg.sgquoting.products.UHGQuotePlanRateInfo;
import com.rwsol.exemplar.process.workflow.SGQuotedWorkflowStateRates;

@Entity
@Table(name = "QT_PLAN")
public class UHGQuotePlan
{

  @Id
  @Column(name = "QUOTE_PLAN_ID")
  private Long quotePlanId;

  @Column(name = "QUOTE_ID")
  private long quoteId;

  @Column(name = "PRODUCT_PLAN_KEY")
  private String productPlanKey;

  @Column(name = "VERSION")
  private Date version;

  @Column(name = "NAME")
  private String name;

  @Column(name = "QUOTE_PACKAGE_ID")
  private Long quotePackageId;

  @Column(name = "PKG_PROD_LINE_ID")
  private Long packageProductLineId;

  @Column(name = "PICK_GROUP_KEY")
  private String pickGroupKey;

  @Column(name = "PLSV_PLAN_ID")
  private Long plsvPlanId;

  @Column(name = "PLAN_NICKNAME")
  private String planNickname;

  @Column(name = "EXTERNAL_PLAN_ID")
  private String externalPlanId;

  @Column(name = "EXTERNAL_PLAN_FAMILY_KEY")
  private String externalPlanFamilyKey;

  @Column(name = "PLSV_PLAN_FAMILY_BENEFIT_VALUE_SET_ID")
  private Long plsvPlanFamilyBenefitValueSetId;

  @Column(name = "SUBGROUP_ID")
  private Long subgroupId;

  @Column(name = "DUAL_PRIMARY_PLAN")
  private Boolean primaryPlan;

  @Column(name = "DUAL_PRIMARY_PLAN_ID")
  private Long primaryPlanId;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "QUOTE_PLAN_ID", updatable = false)
  private Set<UHGQuotePlanExternalInfo> uhgQuotePlanExternalInfo;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "QUOTE_PLAN_ID", updatable = false)
  private Set<UHGQuotePlanRateInfo> uhgQuotePlanRateInfo;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "QUOTE_PLAN_ID", updatable = false)
  private Set<SGQuotedWorkflowStateRates> sgQuotedWorkflowStateRates;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "QUOTE_PLAN_ID", updatable = false)
  private UHGQuotePlanExt uhgQuotePlanExt;

  public Long getQuotePlanId()
  {
    return quotePlanId;
  }

  public void setQuotePlanId(Long quotePlanId)
  {
    this.quotePlanId = quotePlanId;
  }

  public long getQuoteId()
  {
    return quoteId;
  }

  public void setQuoteId(long quoteId)
  {
    this.quoteId = quoteId;
  }

  public String getProductPlanKey()
  {
    return productPlanKey;
  }

  public void setProductPlanKey(String productPlanKey)
  {
    this.productPlanKey = productPlanKey;
  }

  public Date getVersion()
  {
    return version;
  }

  public void setVersion(Date version)
  {
    this.version = version;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public Long getQuotePackageId()
  {
    return quotePackageId;
  }

  public void setQuotePackageId(Long quotePackageId)
  {
    this.quotePackageId = quotePackageId;
  }

  public Long getPackageProductLineId()
  {
    return packageProductLineId;
  }

  public void setPackageProductLineId(Long packageProductLineId)
  {
    this.packageProductLineId = packageProductLineId;
  }

  public String getPickGroupKey()
  {
    return pickGroupKey;
  }

  public void setPickGroupKey(String pickGroupKey)
  {
    this.pickGroupKey = pickGroupKey;
  }

  public Long getPlsvPlanId()
  {
    return plsvPlanId;
  }

  public void setPlsvPlanId(Long plsvPlanId)
  {
    this.plsvPlanId = plsvPlanId;
  }

  public String getPlanNickname()
  {
    return planNickname;
  }

  public void setPlanNickname(String planNickname)
  {
    this.planNickname = planNickname;
  }

  public Long getPlsvPlanFamilyBenefitValueSetId()
  {
    return plsvPlanFamilyBenefitValueSetId;
  }

  public void setPlsvPlanFamilyBenefitValueSetId(Long plsvPlanFamilyBenefitValueSetId)
  {
    this.plsvPlanFamilyBenefitValueSetId = plsvPlanFamilyBenefitValueSetId;
  }

  public String getExternalPlanFamilyKey()
  {
    return externalPlanFamilyKey;
  }

  public void setExternalPlanFamilyKey(String externalPlanFamilyKey)
  {
    this.externalPlanFamilyKey = externalPlanFamilyKey;
  }

  public String getExternalPlanId()
  {
    return externalPlanId;
  }

  public void setExternalPlanId(String externalPlanId)
  {
    this.externalPlanId = externalPlanId;
  }

  public Boolean getPrimaryPlan()
  {
    return primaryPlan;
  }

  public void setPrimaryPlan(Boolean primaryPlan)
  {
    this.primaryPlan = primaryPlan;
  }

  public Long getPrimaryPlanId()
  {
    return primaryPlanId;
  }

  public void setPrimaryPlanId(Long primaryPlanId)
  {
    this.primaryPlanId = primaryPlanId;
  }

  public Long getSubgroupId()
  {
    return subgroupId;
  }

  public void setSubgroupId(Long subgroupId)
  {
    this.subgroupId = subgroupId;
  }

  public Set<UHGQuotePlanExternalInfo> getUhgQuotePlanExternalInfo()
  {
    return uhgQuotePlanExternalInfo;
  }

  public void setUhgQuotePlanExternalInfo(Set<UHGQuotePlanExternalInfo> uhgQuotePlanExternalInfo)
  {
    this.uhgQuotePlanExternalInfo = uhgQuotePlanExternalInfo;
  }

  public Set<UHGQuotePlanRateInfo> getUhgQuotePlanRateInfo()
  {
    return uhgQuotePlanRateInfo;
  }

  public void setUhgQuotePlanRateInfo(Set<UHGQuotePlanRateInfo> uhgQuotePlanRateInfo)
  {
    this.uhgQuotePlanRateInfo = uhgQuotePlanRateInfo;
  }

  public Set<SGQuotedWorkflowStateRates> getSgQuotedWorkflowStateRates()
  {
    return sgQuotedWorkflowStateRates;
  }

  public void setSgQuotedWorkflowStateRates(Set<SGQuotedWorkflowStateRates> sgQuotedWorkflowStateRates)
  {
    this.sgQuotedWorkflowStateRates = sgQuotedWorkflowStateRates;
  }

  public UHGQuotePlanExt getUhgQuotePlanExt()
  {
    return uhgQuotePlanExt;
  }

  public void setUhgQuotePlanExt(UHGQuotePlanExt uhgQuotePlanExt)
  {
    this.uhgQuotePlanExt = uhgQuotePlanExt;
  }

}

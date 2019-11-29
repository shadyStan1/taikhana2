package com.rwsol.exemplar.ui.sgquoting.enroll;

import static com.rwsol.exemplar.session.productselection.RatedPlansScreenSession.RatedPlansScreenBean;
import static org.apache.commons.lang3.StringUtils.isEmpty;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import com.connecture.exemplar.appservice.startegies.SgExportStrategy;
import com.connecture.exemplar.appservice.startegies.SgExportStrategyFactory;
import com.connecture.exemplar.common.MemberManagementProcess;
import com.connecture.exemplar.common.membermanagement.MemberManagementType;
import com.connecture.exemplar.grouppolicyadmin.enrollment.GpaEnrollmentProcess;
import com.connecture.exemplar.grouppolicyadmin.enrollment.GpaGroupSetupProcess;
import com.connecture.exemplar.integration.aws.AwsSnsConstants;
import com.connecture.exemplar.integration.aws.AwsSnsProcess;
import com.connecture.integration.crmsync.model.EntityType;
import com.connecture.services.applicationservice.process.ApplicationServiceProcess;
import com.connecture.services.applicationservice.process.domain.ApplicationInfo;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import com.rwsol.exemplar.process.census.CensusVerificationProcess;
import com.rwsol.exemplar.process.common.ExemplarConstants;
import com.rwsol.exemplar.process.common.ModuleEnabledConfig;
import com.rwsol.exemplar.process.common.ProcessPropertyManager;
import com.rwsol.exemplar.process.common.ProcessUtils;
import com.rwsol.exemplar.process.common.UnexpectedProcessException;
import com.rwsol.exemplar.process.crm.CrmProcessQuoteExtension;
import com.rwsol.exemplar.process.groupprofile.GroupProfileData;
import com.rwsol.exemplar.process.groupprofile.GroupProfileProcess;
import com.rwsol.exemplar.process.messagecenter.MessageProcessExtensions;
import com.rwsol.exemplar.process.offanniversary.OffAnniversaryPlanMatchData;
import com.rwsol.exemplar.process.offanniversary.OffAnniversaryPlanMatchProcess;
import com.rwsol.exemplar.process.ownership.BaseOwner;
import com.rwsol.exemplar.process.ownership.ExemplarRoles;
import com.rwsol.exemplar.process.ownership.OwnershipProcess;
import com.rwsol.exemplar.process.productselection.RatedPlanBean;
import com.rwsol.exemplar.process.productselection.RatedPlanSectionBean;
import com.rwsol.exemplar.process.productselection.RatedPlansSubgroupInfo;
import com.rwsol.exemplar.process.quickaccess.ActivityTypeEnum;
import com.rwsol.exemplar.process.quickaccess.RecentActivityProcess;
import com.rwsol.exemplar.process.quote.QuoteProcess;
import com.rwsol.exemplar.process.quote.QuoteStatusType;
import com.rwsol.exemplar.process.quote.XMPQuoteData;
import com.rwsol.exemplar.process.quote.jobs.api.AppStatusInfo;
import com.rwsol.exemplar.process.quotecopy.CopyQuoteInfo;
import com.rwsol.exemplar.process.quotecopy.QuoteCopyProcess;
import com.rwsol.exemplar.process.quoteprofile.QuoteProfileData;
import com.rwsol.exemplar.process.quoteprofile.QuoteProfileProcess;
import com.rwsol.exemplar.process.renewal.feed.ContactInfo;
import com.rwsol.exemplar.process.sgenrollment.SgEnrollmentNotificationProcess;
import com.rwsol.exemplar.process.sgenrollment.SgEnrollmentProcess;
import com.rwsol.exemplar.process.sgenrollment.SmallGroupEnrollmentQuoteData;
import com.rwsol.exemplar.process.sgenrollment.SmallGroupEnrollmentQuoteProcess;
import com.rwsol.exemplar.process.sgenrollment.renewals.SgRenewalsErEnrollmentProcess;
import com.rwsol.exemplar.process.sgenrollment.resource.EnEmployerAppData;
import com.rwsol.exemplar.process.sgrenewals.RenewalPlanMatchData;
import com.rwsol.exemplar.process.sgrenewals.RenewalPlanMatchProcess;
import com.rwsol.exemplar.process.summary.QuoteSummaryData;
import com.rwsol.exemplar.process.summary.SummaryProcess;
import com.rwsol.exemplar.process.userprofile.UserProfileProcess;
import com.rwsol.exemplar.session.productselection.RatedPlansScreenSession;
import com.rwsol.exemplar.ui.common.ActionConstants;
import com.rwsol.exemplar.ui.common.BasePermissions;
import com.rwsol.exemplar.ui.group.CaseInformationActionExtention;
import com.rwsol.exemplar.ui.sgquoting.BaseAction;
import com.rwsol.express.components.contactbook.api.ContactData;
import com.rwsol.express.components.contactbook.api.EmailData;
import com.rwsol.express.ps.constants.EmailCategory;
import com.rwsol.framework.propertyregistry.PropertyRegistry;

public class StartEnrollmentAction extends BaseAction
{
  private static final Logger LOGGER = Logger.getLogger(PlanSelectionToEnrollAction.class);
  private static final long STATE_LEN = 2;

  private EnrollmentResource resource = new EnrollmentResource();
  private QuoteProcess quoteProcess;
  @Autowired
  private QuoteCopyProcess quoteCopyProcess;
  @Autowired
  private QuoteProfileProcess quoteProfileProcess;
  private RatedPlansScreenSession ratedPlansScreenSession;
  private SgEnrollmentProcess sgEnrollmentProcess;
  private SmallGroupEnrollmentQuoteProcess smallGroupEnrollmentQuoteProcess;
  private OwnershipProcess ownershipProcess;
  private CrmProcessQuoteExtension crmProcessQuoteExtension;
  private MessageProcessExtensions messageProcessExtensions;
  @Autowired
  private CensusVerificationProcess censusVerificationProcess;
  private CaseInformationActionExtention caseInformationActionExtention;
  private UserProfileProcess userProfileProcess;
  @Autowired
  private SummaryProcess summaryProcess;

  @Autowired
  private GpaEnrollmentProcess gpaEnrollmentProcess;
  @Autowired
  private MemberManagementProcess memberManagementProcess;
  @Autowired
  private SgExportStrategyFactory sgExportStrategyFactory;
  @Autowired
  private GpaGroupSetupProcess gpaGroupSetupProcess;
  @Autowired
  private RenewalPlanMatchProcess renewalPlanMatchProcess;
  @Autowired
  private OffAnniversaryPlanMatchProcess offAnniversaryPlanMatchProcess;
  @Autowired
  private RecentActivityProcess recentActivityProcess;
  @Autowired
  private SgRenewalsErEnrollmentProcess sgRenewalsErEnrollmentProcess;
  @Autowired
  private AwsSnsProcess awsSnsProcess;
  @Autowired
  private ApplicationServiceProcess applicationServiceProcess;
  @Autowired
  private SgEnrollmentNotificationProcess sgEnrollmentNotificationProcess;
  @Autowired
  private StartEnrollmentActionExtension startEnrollmentActionExtension;
  @Value("${process.esb.crm.enabled}")
  private boolean esbCrmEnabled;

  private long quoteId;
  private long enrollmentId;
  private long groupId;

  private static final Comparator<? super RatedPlanBean> RATED_PLAN_COMPARATOR =
      (first, second) -> ComparisonChain.start()
          .compare(first.getInternalCode(), second.getInternalCode(), Ordering.natural().nullsFirst())
          .compare(first.getPlanType(), second.getPlanType(), Ordering.natural().nullsFirst())
          .compare(first.getQuotePlanId(), second.getQuotePlanId(), Ordering.natural().nullsFirst()).result();
  @Autowired
  private GroupProfileProcess groupProfileProcess;

  public String rest()
  {
    if (method == HttpMethod.GET)
    {
      return get();
    }
    else if (method == HttpMethod.POST)
    {
      return post();
    }
    else
    {
      throw new IllegalArgumentException("Unsupported method: " + method);
    }
  }

  public String get()
  {
    if (!checkPermission())
    {
      return LOGIN;
    }
    checkAppConfig();
    resource.setQuoteId(quoteId);
    resource.setGroupId(groupId);
    resource.setRatedPlansScreenBean(ratedPlansScreenSession.getRatedPlansSubgroupInfoForEnrollSetUp(quoteId, true));

    SmallGroupEnrollmentQuoteData enrollmentQuoteData =
      smallGroupEnrollmentQuoteProcess.readSmallGroupEnrollmentQuoteFromQuote(quoteId);
    if (enrollmentQuoteData != null)
    {
      resource.setEnrollmentId(enrollmentQuoteData.getEnrollmentId());
    }

    resource.setCarrierName(messageProcessExtensions.getClientCarrierName());

    QuoteSummaryData quoteSummaryData = summaryProcess.getQuoteEntries(groupId, quoteId);
    resource.setCreatedBy(quoteSummaryData.getCreatedBy());

    return SUCCESS;
  }

  private String post()
  {
    caseInformationActionExtention.invalidateCachedObjects(quoteId);
    if (!checkPermission())
    {
      return LOGIN;
    }
    checkAppConfig();

    try
    {
      startEnrollmentActionExtension.removeUnselectedQuotePlan(resource, quoteId);
      //Copy quote
      String newQuoteXref = quoteProcess.createQuoteXref();
      CopyQuoteInfo copyQuoteInfo = quoteCopyProcess.prepareQuoteCopy(quoteId);
      copyQuoteInfo.setEnrollmentFlow(true);
      copyQuoteInfo.setNewQuoteDisplayId(newQuoteXref);
      copyQuoteInfo.setCopyPlanOfferings(true);
      long oaQuoteId = quoteId;
      quoteId = quoteCopyProcess.copyQuoteForEnrollment(copyQuoteInfo, quoteId);

      if (resource.isCensusVerified())
      {
        censusVerificationProcess.setCensusVerified(true, quoteId);
      }
      //start enrollment
      
      enrollmentId = copyQuoteInfo.getEnrollmentId();
      resource.setEnrollmentId(copyQuoteInfo.getEnrollmentId());
      resource.setQuoteId(quoteId);
      resource.setGroupId(groupId);
      RatedPlansScreenBean ratedPlans =
        ratedPlansScreenSession.getRatedPlansSubgroupInfoForEnrollSetUp(quoteId, copyQuoteInfo.getEmployerId(), true);
      RatedPlansScreenBean originRatedPlans = resource.getRatedPlansScreenBean();
      if(originRatedPlans == null)
      {
        originRatedPlans = ratedPlansScreenSession.getRatedPlansSubgroupInfoForEnrollSetUp(quoteId, true);
      }
      populatePlanSelections(originRatedPlans, ratedPlans);
      resource.setRatedPlansScreenBean(ratedPlans);
      ratedPlansScreenSession.saveSubgroupPlanSelectionsForEnrollSetup(enrollmentId, ratedPlans);
      updateEmployerDataOnEnrollmentStart(getQuoteXrefForGroupSetupValidation(copyQuoteInfo, oaQuoteId));
      if (ExemplarRoles.EMPLOYER.equals(resource.getSelectedUser()))
      {
        updateEmployerDataOnMessageSent();
        sendConfirmationMail();
      }
      caseInformationActionExtention.customTestMessageSentFlag(this);
      caseInformationActionExtention.invalidateCopiedQuoteCachedObjects(quoteId);
      if (esbCrmEnabled)
      {
        QuoteProfileData quoteProfileData = quoteProfileProcess.getQuoteProfileData(groupId, quoteId);
        long enrQuoteId = quoteProfileData.getQuoteId();
        String enrQuoteXref = quoteProfileData.getQuoteXref();
        awsSnsProcess.publishSnsMessage(enrQuoteId, enrQuoteXref, EntityType.QUOTE,
            AwsSnsConstants.MODIFY_QUOTE_CREATE_SOLD_QUOTE_PLANS);
      }
      else
      {
        boolean sgcrmEnabled = PropertyRegistry.getInstance().getBooleanProperty(
            ProcessPropertyManager.SG_CRM_ENABLED);
        if (sgcrmEnabled)
        {
          QuoteProfileData quoteProfileData = quoteProfileProcess.getQuoteProfileData(groupId, quoteId);
          crmProcessQuoteExtension.createSGEnrollmentQuote(quoteProfileData);
        }
      }
      recentActivityProcess.createSgRecentActivity(groupId, quoteId, ActivityTypeEnum.Enr);
    }
    catch (Exception e)
    {
      LOGGER.error(e.getMessage(), e);
      addActionError(ExceptionUtils.getStackTrace(e));
      return INPUT;
    }
    return SUCCESS;
  }

  private void checkAppConfig()
  {
    GroupProfileData groupProfileData = groupProfileProcess.getGroupProfileData(groupId);
    XMPQuoteData quoteData = quoteProcess.findQuote(quoteId);

    String stateNode = groupProfileData.getGroupState();
    String applicationGroup = getAppConfigGroup(
        ExemplarConstants.APP_CONFIG_SG_ER_ENROLLMENT_GROUP_PREFIX, stateNode);

    ApplicationInfo applicationInfo = applicationServiceProcess.findApplication(applicationGroup,
        quoteData.getRequestedEffectiveDate(), new Date());

    if (applicationInfo == null)
    {
      throw new UnexpectedProcessException("Failed to get the SG ER Application Configuration "
          + "Package for quote id : " + quoteId);
    }
  }

  private String getAppConfigGroup(String appConfigGroupPrefix, String state)
  {
    if (state != null && state.length() == STATE_LEN && ModuleEnabledConfig.appConfigGroupStateEnabled)
    {
      return appConfigGroupPrefix + "_" + state.toUpperCase();
    }

    return appConfigGroupPrefix;
  }

  private void populatePlanSelections(RatedPlansScreenBean originRatedPlans,
                                      RatedPlansScreenBean ratedPlans)
  {
    if (quoteProcess.isParentQuoteRenewal(quoteId))
    {
      populatePlanSelectionsForRenewal(ratedPlans);
    }
    else if (quoteProcess.isParentQuoteOffAniversary(quoteId))
    {
      populatePlanSelectionsForOA(ratedPlans);
    }
    else
    {
      setPlanSelections(originRatedPlans, ratedPlans);
    }
  }

  private void populatePlanSelectionsForRenewal(RatedPlansScreenBean ratedPlans)
  {
    List<RenewalPlanMatchData> renewalPlanMatches = renewalPlanMatchProcess.getPlanMatchByQuoteId(quoteId);
    ratedPlans.getSubgroups().stream()
      .flatMap(subgroup -> subgroup.getSections().stream())
      .flatMap(section -> section.getPlans().stream())
      .forEach(plan -> findPlanSelectionForRenewal(renewalPlanMatches, plan)
        .ifPresent(renewalPlanMatchData -> plan.setSelected(renewalPlanMatchData.getSelected()))
      );
  }

  private void populatePlanSelectionsForOA(RatedPlansScreenBean ratedPlans)
  {
    List<OffAnniversaryPlanMatchData> oaPlanMatches = offAnniversaryPlanMatchProcess.getPlanMatchByQuoteId(quoteId);
    ratedPlans.getSubgroups().stream()
      .flatMap(subgroup -> subgroup.getSections().stream())
      .flatMap(section -> section.getPlans().stream())
      .forEach(plan -> findPlanSelectionForOA(oaPlanMatches, plan)
        .ifPresent(oaPlanMatchData -> plan.setSelected(oaPlanMatchData.getSelected()))
      );
  }

  private Optional<RenewalPlanMatchData> findPlanSelectionForRenewal
    (List<RenewalPlanMatchData> planMatchByQuoteId, RatedPlanBean plan)
  {
    return planMatchByQuoteId.stream()
      .filter(planMatch -> Objects.nonNull(planMatch.getRenewingPlanId()))
      .filter(planMatch -> planMatch.getRenewingPlanId() == plan.getQuotePlanId())
      .findAny();
  }

  private Optional<OffAnniversaryPlanMatchData> findPlanSelectionForOA
    (List<OffAnniversaryPlanMatchData> planMatchByQuoteId, RatedPlanBean plan)
  {
    return planMatchByQuoteId.stream()
      .filter(planMatch -> Objects.nonNull(planMatch.getSelectedPlanId()))
      .filter(planMatch -> planMatch.getSelectedPlanId() == plan.getQuotePlanId())
      .findAny();
  }

  private String getQuoteXrefForGroupSetupValidation(CopyQuoteInfo copyQuoteInfo, long quoteId)
  {
    XMPQuoteData quoteData = quoteProcess.getQuoteData(quoteId);
    return quoteData.isOffAnniversary() ? quoteProcess.findQuoteByID(quoteData.getParentQuoteId()).getQuoteXref()
      : copyQuoteInfo.getParentQuoteData().getQuoteXref();
  }

  private String getCreatedBy()
  {
    long primaryOwnerId = ctx.getSecondaryContext() == null ? ctx.getReferenceId() : ctx.getSecondaryContext().getReferenceId();
    ContactData userContactData = userProfileProcess.findContactData(primaryOwnerId);
    return ProcessUtils.formatFullName(userContactData.getFirstName(), userContactData.getMiddleName(),
            userContactData.getLastName(), userContactData.getNameSuffix());
  }

  private void setPlanSelections(RatedPlansScreenBean origin, RatedPlansScreenBean result)
  {
    for (RatedPlansSubgroupInfo originSubgroup : origin.getSubgroups())
    {
      for (RatedPlansSubgroupInfo resultSubgroup : result.getSubgroups())
      {
        if (originSubgroup.getSubgroupName().equals(resultSubgroup.getSubgroupName()))
        {
          setPlanSelectionForSubgroups(originSubgroup, resultSubgroup);
          break;
        }
      }
    }
  }

  private void setPlanSelectionForSubgroups(RatedPlansSubgroupInfo origin, RatedPlansSubgroupInfo result)
  {
    for (RatedPlanSectionBean originSection : origin.getSections())
    {
      for (RatedPlanSectionBean resultSection : result.getSections())
      {
        if (originSection.getSectionName().equals(resultSection.getSectionName()))
        {
          setPlanSelectionForSections(originSection, resultSection);
          break;
        }
      }
    }
  }

  private void setPlanSelectionForSections(RatedPlanSectionBean origin, RatedPlanSectionBean result)
  {
    List<RatedPlanBean> originPlans = origin.getPlans();
    List<RatedPlanBean> resultPlans = result.getPlans();
    Collections.sort(originPlans, RATED_PLAN_COMPARATOR);
    Collections.sort(resultPlans, RATED_PLAN_COMPARATOR);
    for (int i = 0; i < resultPlans.size(); i++) {
      resultPlans.get(i).setSelected(originPlans.get(i).isSelected());
    }
  }

  private void updateEmployerDataOnEnrollmentStart(String parentQuoteXref)
  {
    if (ExemplarRoles.EMPLOYER.equals(resource.getSelectedUser()))
    {
      XMPQuoteData xmpQuoteData = quoteProcess.getQuoteData(quoteId);
      ContactInfo contactInfo = sgEnrollmentProcess.fetchEmployerContactInfo(xmpQuoteData.getEmployerEID());
      populateContactInformation(contactInfo);
      sgEnrollmentProcess.saveEmployerContactInfo(contactInfo);
      updatePrimaryContactWhenNotPresent(xmpQuoteData.getEmployerEID());
    }
    if (!sgRenewalsErEnrollmentProcess.isErAppEnabled(quoteId))
    {
      gpaGroupSetupProcess.markParentGroupSetupInvalid(parentQuoteXref);
      generateGroupSetup();
    }
    createEmployerApp();
  }

  private void generateGroupSetup()
  {
    if (gpaEnrollmentProcess.isParentQuoteGpaRenewalOrOffAniversary(quoteId))
    {
      sgEnrollmentProcess.createEmployeeAppsForQuote(quoteId);

      MemberManagementType memberManagementType = memberManagementProcess.findMemberManagementTypeByQuoteId(quoteId);
      SgExportStrategy exportStrategyBean = sgExportStrategyFactory.getStrategy(memberManagementType);

      exportStrategyBean.export(quoteId);
    }
  }

  private void createEmployerApp()
  {
    EnEmployerAppData enrAppData = sgEnrollmentProcess.getEnrollmentEmpApplication(enrollmentId);
    enrAppData.setEmployerSetupComplete(new Date());
    if (!sgRenewalsErEnrollmentProcess.isErAppParentQuoteRenewal(quoteId))
    {
      enrAppData.setEmployerAppStarted(new Date());
    }
    if (!sgRenewalsErEnrollmentProcess.isErAppEnabled(quoteId)
        && gpaEnrollmentProcess.isParentQuoteGpaRenewalOrOffAniversary(quoteId))
    {
      enrAppData.setEmployerAppCompleted(new Date());
    }
    sgEnrollmentProcess.updateEnrollmentEmpApplication(enrAppData);
  }

  /**
   * Method to update the primary contact when not filled in
   * quoting group profile page.
   *
   * @param employerId
   */
  private void updatePrimaryContactWhenNotPresent(long employerId)
  {
    ContactInfo contactInfo = sgEnrollmentNotificationProcess.fetchEmployerContactInfo(employerId);
    if (isEmpty(contactInfo.getContact().getFirstName()) && isEmpty(contactInfo.getContact().getLastName()))
    {
      populateContactInformation(contactInfo);
      sgEnrollmentProcess.saveEmployerContactInfo(contactInfo);
    }
  }

  private void populateContactInformation(ContactInfo contactInfo)
  {
    ContactData contact = contactInfo.getContact();
    EmployerResource employer = resource.getEmployer();
    contact.setFirstName(employer.getFirstName());
    contact.setLastName(employer.getLastName());
    contact.setTaxIDString(StringUtils.remove(employer.getFederalTaxId(), '-'));

    EmailData emailData = Iterables.getFirst(contactInfo.getEmails(), new EmailData());
    emailData.setCategory(EmailCategory.NS.PrimaryApplicant.VALUE);
    emailData.setContactID(contact.getId());
    emailData.setEmailValue(employer.getEmail());
    contactInfo.setEmails(Arrays.asList(emailData));
  }

  private void sendConfirmationMail()
  {
    EnEmployerAppData enrAppData = sgEnrollmentProcess.getEnrollmentEmpApplication(enrollmentId);
    String additionalErRepEmailText = enrAppData.getAdditionalErRepEmailText();

    XMPQuoteData xmpQuoteData = quoteProcess.getQuoteData(quoteId);

    // Only Employer Rep should be d owner of this quote
    long currentOwnerId = ownershipProcess.findResourceOwnerByRoleKey(quoteId,
            ExemplarRoles.EMPLOYER);

    LOG.debug("EnrollmentAction.sendConfirmationMail():  ownerId = " + currentOwnerId
            + " groupId = " + groupId + "  enrollmentId = " + quoteId);

    AppStatusInfo appStatusInfo = new AppStatusInfo();
    appStatusInfo.setGroupId(groupId);
    appStatusInfo.setQuoteXref(xmpQuoteData.getQuoteXref());
    appStatusInfo.setQuoteStatusId(QuoteStatusType.APPLYING.getValue());
    appStatusInfo.setEnrollmentId(enrollmentId);
    appStatusInfo.setQuoteId(quoteId);

    BaseOwner sender;
    BaseOwner producer = ownershipProcess.findAssignedProducerForQuote(quoteId);
    if (producer != null)
    {
      sender = producer;
    } else
    {
      BaseOwner salesRep = ownershipProcess.findAssignedSalesRepForQuote(quoteId);
      if (salesRep == null)
      {
        salesRep = ownershipProcess.findAssignedSalesManagerForQuote(quoteId);
      }
      sender = salesRep;
    }
    if (additionalErRepEmailText == null)
    {
      additionalErRepEmailText = resource.getEmployer().getAdditionalEmailText();
    }
    String groupName = groupProfileProcess.getGroupStatus(groupId).getGroupName();
    LOG.debug("EnrollmentAction.sendConfirmationMail(): sending email to consumer.");

    ContactInfo contactInfo = sgEnrollmentProcess.fetchEmployerContactInfo(xmpQuoteData.getEmployerEID());
    sgEnrollmentProcess.sendEnrollmentConfirmationMail(contactInfo, additionalErRepEmailText,
            appStatusInfo, sender, groupName, currentOwnerId,
            ActionConstants.SGEnrollment.VERIFY_EMPLOYER_ACTION,
            ActionConstants.SGEnrollment.SG_EMPLOYER_ENROLL_NAMESPACE);
  }

  public void updateEmployerDataOnMessageSent()
  {
    EnEmployerAppData enrAppData = sgEnrollmentProcess.getEnrollmentEmpApplication(enrollmentId);
    enrAppData.setErMessageSent(true);
    sgEnrollmentProcess.updateEnrollmentEmpApplication(enrAppData);
  }

  private boolean checkPermission()
  {
    return ctx.checkPermission(BasePermissions.SGEN_ENROLLMENT_SETUP_COMPLETE_FORM_ONLINE) ||
            ctx.checkPermission(BasePermissions.SGEN_ER_ACTIVITIES);
  }

  public long getQuoteId()
  {
    return quoteId;
  }

  public void setQuoteId(long quoteId)
  {
    this.quoteId = quoteId;
  }

  public void setQuoteProcess(QuoteProcess quoteProcess)
  {
    this.quoteProcess = quoteProcess;
  }

  public EnrollmentResource getResource()
  {
    return resource;
  }

  public void setResource(EnrollmentResource resource)
  {
    this.resource = resource;
  }

  public long getEnrollmentId()
  {
    return enrollmentId;
  }

  public void setEnrollmentId(long enrollmentId)
  {
    this.enrollmentId = enrollmentId;
  }

  public long getGroupId()
  {
    return groupId;
  }

  public void setGroupId(long groupId)
  {
    this.groupId = groupId;
  }

  public void setSmallGroupEnrollmentQuoteProcess(SmallGroupEnrollmentQuoteProcess smallGroupEnrollmentQuoteProcess)
  {
    this.smallGroupEnrollmentQuoteProcess = smallGroupEnrollmentQuoteProcess;
  }

  public void setRatedPlansScreenSession(RatedPlansScreenSession ratedPlansScreenSession)
  {
    this.ratedPlansScreenSession = ratedPlansScreenSession;
  }

  public void setSgEnrollmentProcess(SgEnrollmentProcess sgEnrollmentProcess)
  {
    this.sgEnrollmentProcess = sgEnrollmentProcess;
  }

  public void setOwnershipProcess(OwnershipProcess ownershipProcess)
  {
    this.ownershipProcess = ownershipProcess;
  }

  public CrmProcessQuoteExtension getCrmProcessQuoteExtension()
  {
    return crmProcessQuoteExtension;
  }

  public void setCrmProcessQuoteExtension(CrmProcessQuoteExtension crmProcessQuoteExtension)
  {
    this.crmProcessQuoteExtension = crmProcessQuoteExtension;
  }


  public MessageProcessExtensions getMessageProcessExtensions()
  {
    return messageProcessExtensions;
  }

  public void setMessageProcessExtensions(MessageProcessExtensions messageProcessExtensions)
  {
    this.messageProcessExtensions = messageProcessExtensions;
  }

  /**
   * @return the caseInformationActionExtention
   */
  public CaseInformationActionExtention getCaseInformationActionExtention()
  {
    return caseInformationActionExtention;
  }

  /**
   * @param caseInformationActionExtention the caseInformationActionExtention to set
   */
  public void setCaseInformationActionExtention(
    CaseInformationActionExtention caseInformationActionExtention)
  {
    this.caseInformationActionExtention = caseInformationActionExtention;
  }

  public UserProfileProcess getUserProfileProcess()
  {
    return userProfileProcess;
  }

  public void setUserProfileProcess(UserProfileProcess userProfileProcess)
  {
    this.userProfileProcess = userProfileProcess;
  }

}

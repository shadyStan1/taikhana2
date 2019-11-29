package com.rwsol.exemplar.ui.sgquoting.enroll;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;

import com.connecture.uhg.sgquoting.products.UHGQuotePlanDAO;
import com.rwsol.exemplar.process.productselection.RatedPlanBean;
import com.rwsol.exemplar.process.productselection.RatedPlanSectionBean;
import com.rwsol.exemplar.process.productselection.RatedPlansSubgroupInfo;
import com.rwsol.exemplar.process.productselection.UHGQuotePlan;
import com.rwsol.exemplar.session.productselection.RatedPlansScreenSession.RatedPlansScreenBean;

@RunWith(MockitoJUnitRunner.class)
public class UhgStartEnrollmentActionTest {

@InjectMocks
private UhgStartEnrollmentAction uhgStartEnrollmentAction;

@Mock
private EnrollmentResource resource;

@Mock
private UHGQuotePlanDAO uhgQuotePlanDAO;


private static final Long QUOTE_ID = 112041l;
@Before
  public void setUp() throws Exception
  {
	 resource = new EnrollmentResource();
	 resource.setRatedPlansScreenBean(getRatedPlansScreenBean());
  }

@Test
public void getUnselectedQuotePlans()
{
	//when(resource.getRatedPlansScreenBean().getSubgroups()).thenReturn(getRatedPlansSubgroupInfo());
	when(uhgQuotePlanDAO.fetchUnselectedQuotePlan(Mockito.anyObject(), Mockito.anyLong())).thenReturn(getUhgQuotePlans());
    uhgStartEnrollmentAction.removeUnselectedQuotePlan(resource, QUOTE_ID);
    Mockito.doNothing().when(uhgQuotePlanDAO).removeUnselectedQuotePlan(Mockito.anyList());
}

private List<UHGQuotePlan> getUhgQuotePlans()
{
	List<UHGQuotePlan> unSelectedPlanList = new ArrayList<>();
	UHGQuotePlan plan1 = new UHGQuotePlan();
	plan1.setQuotePlanId(12222l);
	plan1.setQuoteId(QUOTE_ID);
	
	UHGQuotePlan plan2 = new UHGQuotePlan();
	plan2.setQuotePlanId(13333l);
	plan2.setQuoteId(QUOTE_ID);
	
	UHGQuotePlan plan3 = new UHGQuotePlan();
	plan3.setQuotePlanId(14444l);
	plan3.setQuoteId(QUOTE_ID);
	unSelectedPlanList.add(plan1);
	unSelectedPlanList.add(plan2);
	unSelectedPlanList.add(plan3);
	return unSelectedPlanList;
}

private RatedPlansScreenBean getRatedPlansScreenBean()
{
	RatedPlansScreenBean ratedPlansScreenBean = new RatedPlansScreenBean();
	ratedPlansScreenBean.setSubgroups(getRatedPlansSubgroupInfo());
	return ratedPlansScreenBean;
}

private List<RatedPlansSubgroupInfo> getRatedPlansSubgroupInfo()
{
	List<RatedPlansSubgroupInfo> subGroupList = new ArrayList<>();
	List<RatedPlanSectionBean> sectionList = new ArrayList<>();
	RatedPlansSubgroupInfo subGroup = new RatedPlansSubgroupInfo();
	RatedPlanSectionBean section = new RatedPlanSectionBean();
	section.setPlans(getPlans());
	sectionList.add(section);
	subGroup.setSections(sectionList);
	subGroupList.add(subGroup);
	return subGroupList;
}

private List<RatedPlanBean> getPlans()
{
	List<RatedPlanBean> planList = new ArrayList<>();
	RatedPlanBean plan1 = new RatedPlanBean();
	plan1.setQuotePlanId(1234);
	plan1.setSelected(true);
	
	RatedPlanBean plan2 = new RatedPlanBean();
	plan2.setQuotePackageId(5678);
	plan2.setSelected(true);
	
	RatedPlanBean plan3 = new RatedPlanBean();
	plan3.setQuotePackageId(12222);
	plan3.setSelected(false);
	
	RatedPlanBean plan4 = new RatedPlanBean();
	plan3.setQuotePackageId(13333);
	plan3.setSelected(false);
	
	RatedPlanBean plan5 = new RatedPlanBean();
	plan3.setQuotePackageId(14444);
	plan3.setSelected(false);
	planList.add(plan1);
	planList.add(plan2);
	planList.add(plan3);
	planList.add(plan4);
	planList.add(plan5);
	
	return planList;
}

}

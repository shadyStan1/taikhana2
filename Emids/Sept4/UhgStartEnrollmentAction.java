package com.rwsol.exemplar.ui.sgquoting.enroll;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.connecture.uhg.sgquoting.products.UHGQuotePlanDAO;
import com.rwsol.exemplar.process.productselection.RatedPlansSubgroupInfo;
import com.rwsol.exemplar.process.productselection.UHGQuotePlan;
import com.rwsol.exemplar.process.productselection.RatedPlanSectionBean;
import  com.rwsol.exemplar.process.productselection.RatedPlanBean;

public class UhgStartEnrollmentAction implements StartEnrollmentActionExtension {
@Autowired
private UHGQuotePlanDAO quotePlanDAO;

@Override
public void removeUnselectedQuotePlan(EnrollmentResource resource, Long quoteId)
{
	List<UHGQuotePlan> unSelectedPlan = getUnselectedQuotePlans(resource, quoteId);
	quotePlanDAO.removeUnselectedQuotePlan(unSelectedPlan);
}

private List<UHGQuotePlan> getUnselectedQuotePlans(EnrollmentResource resource, Long quoteId) 
{
	List<Long> planIdList = new ArrayList<>();
	List<RatedPlansSubgroupInfo> subGroups = resource.getRatedPlansScreenBean().getSubgroups();
	for (RatedPlansSubgroupInfo subGrp : subGroups)
	{
		for (RatedPlanSectionBean section : subGrp.getSections()) 
		{
			for(RatedPlanBean plan : section.getPlans())
			{
				if(!plan.isSelected())
				{
					planIdList.add(plan.getQuotePlanId());
				}
			}
		}
	}
	return quotePlanDAO.fetchUnselectedQuotePlan( planIdList, quoteId);
}

}


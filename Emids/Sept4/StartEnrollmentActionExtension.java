package com.rwsol.exemplar.ui.sgquoting.enroll;

import com.rwsol.exemplar.session.productselection.RatedPlansScreenSession.RatedPlansScreenBean;

public interface StartEnrollmentActionExtension
{

	default void removeUnselectedQuotePlan(EnrollmentResource resource, Long quoteId)
	{
		// do nothing
	}
}

package com.rwsol.exemplar.process.productselection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QT_PLAN")
public class UHGQuotePlan
{

	@Id
	@Column(name = "QUOTE_PLAN_ID")
	private Long quotePlanId;

	@Column(name = "QUOTE_ID")
	private long quoteId;

	public Long getQuotePlanId() {
		return quotePlanId;
	}

	public void setQuotePlanId(Long quotePlanId) {
		this.quotePlanId = quotePlanId;
	}

	public long getQuoteId() {
		return quoteId;
	}

	public void setQuoteId(long quoteId) {
		this.quoteId = quoteId;
	}
	
	

}

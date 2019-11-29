package com.mapping.HibernateMappings.model;

import java.util.Set;

public class Cart1 {
	
	private long id;
	private double total;

	private Set<Items1> items;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Set<Items1> getItems() {
		return items;
	}

	public void setItems(Set<Items1> items) {
		this.items = items;
	}

}

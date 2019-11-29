package com.mapping.HibernateMappings.model;

import java.util.Set;

public class Items1 {

	private long id;
	private double itemPrice;
	private String itemDesc;
	
	private Set<Cart1> carts;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	
	public Set<Cart1> getCarts() {
		return carts;
	}
	public void setCarts(Set<Cart1> carts) {
		this.carts = carts;
	}
	
}

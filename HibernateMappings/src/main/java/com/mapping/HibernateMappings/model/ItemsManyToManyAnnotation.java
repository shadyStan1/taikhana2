package com.mapping.HibernateMappings.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Item1")
public class ItemsManyToManyAnnotation {

	@Id
	@Column(name="item_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="item_price")
	private double itemPrice;
	
	@Column(name="item_desc")
	private String itemDesc;
	
	@ManyToMany(targetEntity=CartManyToManyAnnotation.class, cascade = {javax.persistence.CascadeType.ALL})
	@JoinTable(name="Cart_Items",  joinColumns={@JoinColumn(name="item_id")}, 
			inverseJoinColumns={@JoinColumn(name="cart_id")})
	private Set<CartManyToManyAnnotation> carts;

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

	public Set<CartManyToManyAnnotation> getCarts() {
		return carts;
	}

	public void setCarts(Set<CartManyToManyAnnotation> carts) {
		this.carts = carts;
	}
	
}

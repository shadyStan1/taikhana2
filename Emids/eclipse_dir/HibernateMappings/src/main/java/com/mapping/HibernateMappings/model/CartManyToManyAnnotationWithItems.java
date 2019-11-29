package com.mapping.HibernateMappings.model;

import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name="Cart1")
public class CartManyToManyAnnotationWithItems {
	
	@Id
	@Column(name="cart_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long cart_id;
	
	@Column(name="cart_total")
	private double total;
	
	@ManyToMany(targetEntity=ItemsManyToManyAnnotationToCart.class, cascade={CascadeType.ALL})
	@JoinTable(name="Cart_Items", joinColumns={@JoinColumn(name="cart_id")},
				inverseJoinColumns={@JoinColumn(name="item_id")})
	private Set<ItemsManyToManyAnnotationToCart> items;

	public long getCart_id() {
		return cart_id;
	}

	public void setCart_id(long cart_id) {
		this.cart_id = cart_id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Set<ItemsManyToManyAnnotationToCart> getItems() {
		return items;
	}

	public void setItems(Set<ItemsManyToManyAnnotationToCart> items) {
		this.items = items;
	}
	
}

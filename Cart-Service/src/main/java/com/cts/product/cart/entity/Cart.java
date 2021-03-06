package com.cts.product.cart.entity;

import java.io.Serializable;
import java.util.List;


public class Cart implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private int cartId;
	private String name;
	private double price;
	private double itemTotal;
	
	public Cart() {
		super();
	}

	public Cart(int cartId, String name, double price,double itemTotal) {
		super();
		this.cartId = cartId;
		this.name = name;
		this.price = price;
		
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(double itemTotal) {
		this.itemTotal = itemTotal;
	}


}

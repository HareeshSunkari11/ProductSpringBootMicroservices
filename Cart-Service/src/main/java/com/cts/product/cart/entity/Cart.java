package com.cts.product.cart.entity;

import java.io.Serializable;
import java.util.List;


public class Cart implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private int cartId;
	private String name;
	private double totalPrice;
	
	public Cart() {
		super();
	}

	public Cart(int cartId, String name, double totalPrice) {
		super();
		this.cartId = cartId;
		this.name = name;
		this.totalPrice = totalPrice;
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

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", name=" + name + ", totalPrice=" + totalPrice + "]";
	}
	
	

}

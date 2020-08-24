package com.cts.product.cart.entity;

import java.io.Serializable;

public class CartItemLine implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private Cart cart;
	private int quantity;
	
	
	public CartItemLine() {
		super();
	}

	public CartItemLine(Cart cart, int quantity) {
		super();
		this.cart = cart;
		this.quantity = quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	@Override
	public String toString() {
		return "CartItemLine [cart=" + cart + ", quantity=" + quantity + "]";
	}
	
	
	
	
	
}

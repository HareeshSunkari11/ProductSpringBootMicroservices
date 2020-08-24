package com.cts.product.order.entity;

import java.io.Serializable;

import javax.persistence.Entity;


public class CartItemLine{

	
	private Cart item;
	private int qty;
	
	public CartItemLine() {
		super();
	}

	public CartItemLine(Cart item, int qty) {
		super();
		this.item = item;
		this.qty = qty;
	}


	public Cart getItem() {
		return item;
	}

	public void setItem(Cart item) {
		this.item = item;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
}

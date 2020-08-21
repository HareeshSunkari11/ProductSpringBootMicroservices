package com.cts.product.cart.entity;

import java.io.Serializable;
import java.util.List;


public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private double price;
	private String description;
	
	//@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<CartItemLine> cartItemLineList;

	public Product() {
		super();
	}

	public Product(int id, String name, double price, String description, List<CartItemLine> cartItemLineList) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.cartItemLineList = cartItemLineList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<CartItemLine> getCartItemLineList() {
		return cartItemLineList;
	}

	public void setCartItemLineList(List<CartItemLine> cartItemLineList) {
		this.cartItemLineList = cartItemLineList;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", cartItemLineList=" + cartItemLineList + "]";
	}
	

}

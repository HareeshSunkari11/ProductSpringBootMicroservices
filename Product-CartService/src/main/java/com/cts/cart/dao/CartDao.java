package com.cts.cart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.cart.entity.Cart;

public interface CartDao extends JpaRepository<Cart, Integer>{
	

}

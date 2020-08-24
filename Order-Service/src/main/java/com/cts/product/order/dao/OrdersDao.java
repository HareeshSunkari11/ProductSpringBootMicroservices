package com.cts.product.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.product.order.entity.Orders;

public interface OrdersDao extends JpaRepository<Orders, Integer>{
	
	//public Users findByUser(String users);

}

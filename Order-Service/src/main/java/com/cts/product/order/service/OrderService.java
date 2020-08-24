package com.cts.product.order.service;

import java.util.List;

import com.cts.product.order.entity.Orders;

public interface OrderService {
	
	List<Orders> findAll(String user);
	
	//Orders saveOrders(String user);
	

}

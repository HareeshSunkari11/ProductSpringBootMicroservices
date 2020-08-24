package com.cts.product.order.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.product.order.dao.OrdersDao;
import com.cts.product.order.entity.CartItemLine;
import com.cts.product.order.entity.Orders;
import com.cts.product.order.entity.Users;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrdersDao ordersDao;

	@Override
	public List<Orders> findAll(String user) {
		return ordersDao.findAll();
	}
	
	/*
	 * public Orders saveOrders(String user) {
	 * 
	 * return ordersDao.save(user); }
	 */


}

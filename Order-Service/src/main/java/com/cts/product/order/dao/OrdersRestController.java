package com.cts.product.order.dao;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cts.product.order.entity.CartItemLine;
import com.cts.product.order.entity.Orders;
import com.cts.product.order.entity.Users;
import com.cts.product.order.service.OrderService;

@CrossOrigin
@RestController
@RequestMapping("/order/{user}")
public class OrdersRestController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrdersDao orderDao;

	@GetMapping
	public List<Orders> getAllOrders(String user){
		return orderDao.findAll();
		
	}
	@PostMapping
	public Orders save(@PathVariable String user) {
		System.out.println("=======> user Info: " + user);
		String url = "http://localhost:8083/cart/" +user;
		System.out.println("Fetching cart data from " + url);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CartItemLine[]> response = restTemplate.getForEntity(url, CartItemLine[].class);
		CartItemLine[] itemLines = response.getBody();
		for(CartItemLine itemLine : itemLines) {
			System.out.println(itemLine.getItem().getId());
			System.out.println(itemLine.getItem().getName());
			System.out.println(itemLine.getItem().getPrice());
			System.out.println(itemLine.getQty());
			System.out.println("Total for this Item: " + itemLine.getQty() * itemLine.getItem().getPrice());
		}
			double totalAmount = Arrays.stream(itemLines).mapToDouble(line -> line.getItem().getItemTotal()).sum();
			Orders order = new Orders();
			order.setDate(LocalDateTime.now());

			Users userName = new Users();
			userName.setUserId(user);
			userName.setPassword("password1$");
			userName.setUserRole("user-role");
			order.setUsers(userName);

			order.setAmount(totalAmount);
			Orders savedOrder = orderDao.save(order);
			return savedOrder;
		
	}

}

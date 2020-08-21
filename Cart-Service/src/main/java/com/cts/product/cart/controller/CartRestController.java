package com.cts.product.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.product.cart.dao.CartDaoImpl;
import com.cts.product.cart.entity.CartItemLine;

@RestController
@CrossOrigin
@RequestMapping("/cart")
class CartRestController {
	
	@Autowired
	private CartDaoImpl cartDao;
	
	@PostMapping("/{userName}")
	public CartItemLine displayCartOrders(@RequestBody CartItemLine cartItemLine ,@PathVariable("userName") String user) {
		
		cartDao.save(user, cartItemLine);
		return cartItemLine;
		
	}
	
	@GetMapping("/{userName}")
	public List<CartItemLine> getCartItems(@PathVariable("userName") String user) {
		
		List<CartItemLine> cartItems = cartDao.findAll(user);
		cartItems.forEach(System.out::println);
		
		return cartItems;
	}
	
	@DeleteMapping("/{userName}")
	public void clearCart(@PathVariable("userName") String user) {

		cartDao.clear(user);
		System.out.println(">>>> Cleared....");
	}

}

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
import com.cts.product.cart.entity.Cart;
import com.cts.product.cart.entity.CartItemLine;

@RestController
@CrossOrigin
@RequestMapping("/cart/{user}")
class CartRestController {
	
	@Autowired
	private CartDaoImpl cartDao;
	
	@PostMapping
	public CartItemLine displayCartOrders(@RequestBody CartItemLine cartItemLine ,@PathVariable() String user) {
		cartItemLine.getCart().setItemTotal(cartItemLine.getQuantity()*cartItemLine.getCart().getPrice());
		//cartItemLine.setTotalPrice(cart.getPrice() * cartItemLine.getQuantity());
		cartDao.save(user, cartItemLine);
		return cartItemLine;
		
	}
	
	@GetMapping
	public List<CartItemLine> getCartItems(@PathVariable String user) {
		
		List<CartItemLine> cartItems = cartDao.findAll(user);
		cartItems.forEach(System.out::println);
		
		return cartItems;
	}
	
	@DeleteMapping
	public void clearCart(@PathVariable String user) {

		cartDao.clear(user);
		System.out.println(">>>> Cleared....");
	}

}

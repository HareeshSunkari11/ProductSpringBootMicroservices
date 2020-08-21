package com.cts.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.cart.dao.UserDao;
import com.cts.cart.entity.Cart;
import com.cts.cart.entity.CartItem;
import com.cts.cart.entity.Product;
import com.cts.cart.entity.User;
import com.cts.cart.services.CartItemService;
import com.cts.cart.services.CartServices;
import com.cts.cart.services.ProductCatalogServiceProxy;

@RestController
@RequestMapping("/cart")
public class CartRestController {
	
	@Autowired
	private CartServices cartService;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ProductCatalogServiceProxy productCatalogServiceProxy;
	
	
	@RequestMapping("/{cartId}")
	public @ResponseBody Cart getCartById(@PathVariable(value="cartId") int cartId){
		return cartService.findById(cartId);

	}
	
	@PostMapping("add/{id}")
	public void addItemToCart(@PathVariable(value = "id") int id,@PathVariable(value = "userID") int userID) {
		
		User user = userDao.findById(userID).get();
		Cart cart = user.getCart();
		Product product = productCatalogServiceProxy.getProduct(id);
		
		List<CartItem> cartItems = cart.getCartItems();
		
		for(int i=0;i<cartItems.size();i++){

			if(product.getId() == cartItems.get(i).getProduct().getId()){
				CartItem cartItem = cartItems.get(i);
				cartItem.setQuantity(cartItem.getQuantity() + 1);
				cartItem.setTotalPrice(product.getPrice() * cartItem.getQuantity());
				cartItemService.addCartItem(cartItem);
				return;
			}

		}
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setQuantity(1);
		cartItem.setTotalPrice(product.getPrice() * cartItem.getQuantity());
		cartItem.setCart(cart);
		cartItemService.addCartItem(cartItem);
		
	}
	
	

}

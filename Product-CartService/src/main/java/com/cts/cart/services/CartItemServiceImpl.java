package com.cts.cart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

import com.cts.cart.dao.CartItemDao;
import com.cts.cart.entity.Cart;
import com.cts.cart.entity.CartItem;
import com.cts.cart.entity.Product;

@EnableFeignClients
@Service
public class CartItemServiceImpl implements CartItemService {
	
	@Autowired
	private CartItemDao cartItemDao;
	
	@Autowired
	private ProductCatalogServiceProxy productCatalogServiceProxy;

	@Override
	public void addCartItem(CartItem cartItem) {
		cartItemDao.save(cartItem);
	}
	
	@Override
	public void removeCartItem(CartItem cartItem) {
		cartItemDao.delete(cartItem);
	}

	@Override
	public void removeAllCartItems(Cart cart) {
		List<CartItem> cartItems = cart.getCartItems();
		for(CartItem cartItem : cartItems){
			removeCartItem(cartItem);
		}
	}

	@Override
	public CartItem findCartItemByProductId(int id) {
		//Product product = productCatalogServiceProxy.getProduct(id);
		return cartItemDao.findCartItemByProductId(id);
	}

}

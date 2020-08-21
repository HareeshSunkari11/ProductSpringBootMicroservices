package com.cts.cart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.cart.dao.CartDao;
import com.cts.cart.entity.Cart;

@Service
public class CartServiceImpl implements CartServices {
	
	@Autowired
	private CartDao  cartDao;

	
	@Override
	public Cart findById(int id) {
		return cartDao.findById(id).get();
	}

	/*
	 * @Override public void update(Cart cart) { cartDao.update(cart); }
	 */
}

package com.cts.product.cart.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.cts.product.cart.entity.CartItemLine;

@Repository
public class CartDaoImpl {
	
	private static final String KEY = "CartItemLine";
	@Autowired
	private RedisTemplate<String, String> template;
	
	 private HashOperations<String, Long,CartItemLine> hashOperations;
	// inject the template as ListOperations
	// can also inject as Value, Set, ZSet, and HashOperations
	
	@Resource(name = "redisTemplate")
	private ListOperations<String, CartItemLine> listOps;
	
	public CartItemLine save(String user, CartItemLine cartItemLine) {
		listOps.leftPush(user, cartItemLine);
		return cartItemLine;
	}
	
	public List<CartItemLine> findAll(String user) {
		return listOps.range(user, 0, -1);
	}

	public void clear(String user) {
		System.out.println("USR Name::::: "+user);
		hashOperations.delete(KEY,user);
	}

}

package com.cts.product.price.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.product.price.dao.ProductDao;
import com.cts.product.price.entity.Product;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	private ProductDao productDao;

	@Override
	public double getPriceById(int id) {
	
		Product product = productDao.findById(id).orElse(null);
		if(product!= null) {
		return product.getPrice();
			
		}
		return 0.0;
	}

	
}

package com.cts.cart.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.cart.entity.Product;

@FeignClient(name="product-catalog-service",url="http://localhost:8081/api")
public interface ProductCatalogServiceProxy {
	
	@GetMapping("/products/{id}")
	Product getProduct(@PathVariable("id") int id) ;
}

package com.cts.product.price.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.product.price.service.PriceService;

@RestController
@RequestMapping("/price")
public class PriceController {
	
	@Autowired
	private PriceService priceService;
	
	@GetMapping("/getPrice/{id}")
	public double getPriceByProductId(@PathVariable("id") int id) {
		return priceService.getPriceById(id);
	}

}

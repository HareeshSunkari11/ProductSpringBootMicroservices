package com.cts.product.catalog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.product.catalog.dao.ProductDao;
import com.cts.product.catalog.entity.Product;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> findAllProducts() {
		return productDao.findAll();
	}
	
	@Override
	public Product findById(int id) {
		return productDao.findById(id).get();
	}

	@Override
	public Product findByNameOfProduct(String nameOfProduct) {
		return productDao.findByName(nameOfProduct);
	}

	@Override
	public List<Product> saveProducts(List<Product> products) {
		return productDao.saveAll(products);
	}

	@Override
	public Product saveproduct(Product product) {
		return productDao.save(product);
	}

	@Override
	public void deleteProductById(int id) {
		productDao.deleteById(id);
		
	}

	

}
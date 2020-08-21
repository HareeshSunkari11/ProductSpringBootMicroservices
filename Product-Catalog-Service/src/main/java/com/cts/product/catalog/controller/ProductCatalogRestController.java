package com.cts.product.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.product.catalog.dao.ProductDao;
import com.cts.product.catalog.dao.ReviewDao;
import com.cts.product.catalog.entity.Product;
import com.cts.product.catalog.entity.Review;
import com.cts.product.catalog.service.ProductService;
import com.cts.product.catalog.service.ReviewService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductCatalogRestController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ReviewDao reviewDao;
	
	
	@GetMapping("/products")
	public List<Product> listAllProducts(){
		return productService.findAllProducts();
		
	}
	
	@GetMapping("/products/{id}")
	public Product getProduct(@PathVariable("id") int id) {
		return productService.findById(id);
		
	}
	
	@GetMapping("/products/byName/{name}")
	public Product getProductByName(@PathVariable("name") String name) {
		return productService.findByNameOfProduct(name);
		
	}
	
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products){
		return productService.saveProducts(products);
		
	}
	
	
	
	@PostMapping("/addProduct/{id}")
	public Product addProduct(@RequestBody Product product) {
		return productService.saveproduct(product);
		
	}
	
	@DeleteMapping("/deleteProducts/{id}")
	public void deleteProductById(@PathVariable("id") int id) {
		productService.deleteProductById(id);
		
	}
	
	/*
	 * @GetMapping("/products/{id}/reviews") public List<Review>
	 * getReviewsByProduct() { return reviewService.findAllReviews();
	 * 
	 * }
	 */
	
	@GetMapping("/products/{id}/reviews")
    public Page<Review> getAllCommentsByPostId(@PathVariable (value = "id") int id,
                                                Pageable pageable) {
        return reviewDao.findByProductId(id, pageable);
    }
	/*
	 * @PostMapping("/products/{id}/reviews") public List<Review> addListOfReview()
	 * { return reviewService.saveReviews(reviews);
	 * 
	 * }
	 */
	
	@PostMapping("/products/{id}/reviews")
	public Review addReview(@PathVariable("id") int id,@RequestBody Review review) throws Exception {
		
		return productDao.findById(id).map(product ->{
			review.setProduct(product);
			return reviewService.saveReview(review);
		}).orElseThrow(() -> new Exception("product " + id + " not found"));
	}
		
	
}
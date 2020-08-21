package com.cts.product.catalog.service;

import java.util.List;

import com.cts.product.catalog.entity.Product;
import com.cts.product.catalog.entity.Review;

public interface ReviewService {
	
	List<Review> findAllReviews();
	
	Review findById(int reviewId);
	
	List<Review> saveReviews(List<Review> reviews);
	
	Review saveReview(Review review);
	

}
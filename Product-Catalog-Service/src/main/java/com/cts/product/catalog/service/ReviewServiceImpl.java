package com.cts.product.catalog.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.product.catalog.dao.ProductDao;
import com.cts.product.catalog.dao.ReviewDao;
import com.cts.product.catalog.entity.Review;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	private ReviewDao reviewDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public Review findById(int reviewId) {
		return reviewDao.findById(reviewId).get();
	}


	@Override
	public List<Review> findAllReviews() {
		return reviewDao.findAll();
	}


	@Override
	public List<Review> saveReviews(List<Review> reviews) {
		return reviewDao.saveAll(reviews);
	}


	@Override
	public Review saveReview(Review review) {
		review.getProduct();
		return reviewDao.save(review);
	}

}
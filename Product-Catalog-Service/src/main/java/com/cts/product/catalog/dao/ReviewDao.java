package com.cts.product.catalog.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.product.catalog.entity.Review;

public interface ReviewDao extends JpaRepository<Review, Integer>{

	 Page<Review> findByProductId(int id, Pageable pageable);
}

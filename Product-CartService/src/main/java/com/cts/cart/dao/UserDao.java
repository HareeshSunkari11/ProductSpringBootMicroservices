package com.cts.cart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.cart.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

}

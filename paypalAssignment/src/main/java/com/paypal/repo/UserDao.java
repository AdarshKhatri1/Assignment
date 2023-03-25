package com.paypal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paypal.model.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	public User findByMobileNo(String mobileNo);

}

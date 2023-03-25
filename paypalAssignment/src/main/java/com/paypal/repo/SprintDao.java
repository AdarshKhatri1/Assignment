package com.paypal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paypal.model.Sprint;

public interface SprintDao extends JpaRepository<Sprint, Integer> {

}

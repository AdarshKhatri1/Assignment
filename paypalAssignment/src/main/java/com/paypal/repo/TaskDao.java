package com.paypal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paypal.model.Task;

public interface TaskDao extends JpaRepository<Task, Integer>{


}

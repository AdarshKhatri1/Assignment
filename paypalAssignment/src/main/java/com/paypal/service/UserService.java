package com.paypal.service;

import java.util.List;

import com.paypal.Exception.UserException;
import com.paypal.model.Task;
import com.paypal.model.User;

public interface UserService {

	public User AddUser(User user)throws UserException;
	public List<Task> Task(Integer id)throws UserException;
	public User addTask( Integer UserID, Task task) throws UserException;
}

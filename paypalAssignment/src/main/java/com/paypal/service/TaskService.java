package com.paypal.service;

import com.paypal.Exception.SprintException;
import com.paypal.Exception.TaskException;
import com.paypal.Exception.UserException;
import com.paypal.model.Task;

public interface TaskService {
	
	public Task addTask(Integer SprintID,Integer userID,Task task1) throws TaskException, SprintException, UserException;
	public Task updateTask(Integer userID, Task task1) throws TaskException, UserException;
	

}

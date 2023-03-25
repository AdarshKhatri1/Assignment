package com.paypal.service;

import java.util.List;

import com.paypal.Exception.SprintException;
import com.paypal.Exception.UserException;
import com.paypal.model.Sprint;
import com.paypal.model.Task;

public interface SprintService {
	
	public Sprint addSpring(Sprint sprint) throws SprintException;
	public List<Task> Task (Integer id) throws SprintException;
	public Sprint addTask(Integer SprintID ,Integer userID, Task task) throws SprintException, UserException ;
}

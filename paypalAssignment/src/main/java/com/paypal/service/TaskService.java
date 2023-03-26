package com.paypal.service;

import com.paypal.Exception.SprintException;
import com.paypal.Exception.TaskException;
import com.paypal.Exception.UserException;
import com.paypal.dto.TaskDto;
import com.paypal.model.Task;

public interface TaskService {
	public TaskDto addTask(Task task,Integer SprintID, Integer UserID) throws SprintException, UserException;
	public Boolean deleteTask(Integer taskID)throws TaskException;
}

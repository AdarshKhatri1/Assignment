package com.paypal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.Exception.SprintException;
import com.paypal.Exception.TaskException;
import com.paypal.Exception.UserException;
import com.paypal.model.Sprint;
import com.paypal.model.Task;
import com.paypal.model.User;
import com.paypal.repo.SprintDao;
import com.paypal.repo.TaskDao;
import com.paypal.repo.UserDao;

@Service
public class TaskServiceImpl implements TaskService {
	@Autowired
	private SprintDao sprintDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private TaskDao taskDao;

	@Autowired
	UserService userService;
	
	@Autowired
	SprintService sprintService;
	
	
	

	@Override
	public Task addTask(Integer SprintID, Integer userID, Task task1)
			throws TaskException, SprintException, UserException {
		// TODO Auto-generated method stub

		
		Optional<Sprint> sprint = sprintDao.findById(SprintID);
		if (sprint.isEmpty()) {
			throw new SprintException("sprint not found with id " + SprintID);
		}
		

		Optional<User> user = userDao.findById(userID);
		if (user.isEmpty()) {
			throw new UserException("user not found with id " + userID);
		}
		
		task1.setUser(user.get());
		task1.setAssigneeName(user.get().getName());
		Task task = taskDao.save(task1);
		sprintService.addTask(SprintID, userID, task);
		userService.addTask(userID, task);
		
		return task;
	}

	@Override
	public Task updateTask(Integer userID, Task task1) throws TaskException, UserException {
		// TODO Auto-generated method stub

		Optional<User> user = userDao.findById(userID);
		if (user.isEmpty()) {
			throw new UserException("user not found with id " + userID);
		}
		task1.setUser(user.get());
		task1.setAssigneeName(user.get().getName());
		Task task = taskDao.save(task1);
		return taskDao.save(task);
	}

}

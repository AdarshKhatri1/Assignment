package com.paypal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.Exception.SprintException;
import com.paypal.Exception.TaskException;
import com.paypal.Exception.UserException;
import com.paypal.dto.TaskDto;
import com.paypal.model.Sprint;
import com.paypal.model.Task;
import com.paypal.model.User;
import com.paypal.repo.SprintDao;
import com.paypal.repo.TaskDao;
import com.paypal.repo.UserDao;

@Service
public class TaskServiceImpl implements TaskService{
	@Autowired
	private SprintDao sprintDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private TaskDao taskDao;


	@Override
	public TaskDto addTask(Task task,Integer SprintID, Integer UserID) throws SprintException, UserException{
		// TODO Auto-generated method stub
		Task task2 = taskDao.save(task);
		
		Optional<Sprint> sprint = sprintDao.findById(SprintID);
		if(sprint.isEmpty()) {
			throw new SprintException("sprint not found with id "+SprintID);
		}
		sprint.get().getTaskList().add(task2);
		
		
	 Optional<User> user = userDao.findById(UserID);
	 if(user.isEmpty()) {
		 throw new UserException("user not found with id "+UserID);
	 }
		user.get().getUserTaskList().add(task2);
		
	
		task2.setUserAssignedToTask(user.get());
		task2.setSprint(sprint.get());
		
		task2 = taskDao.save(task2);
			
		TaskDto taskDto =  new TaskDto().createnewdto(task2);

		
		
		return taskDto;
	}


	@Override
	public Boolean deleteTask(Integer taskID) throws TaskException {
		// TODO Auto-generated method stub
		
		Optional<Task>  task = taskDao.findById(taskID);
		if(task.isEmpty()) {
			throw new TaskException("Task not exist with id "+ taskID);
		}
		
		 taskDao.deleteById(taskID);
		return true;
	}
	
	
	


}

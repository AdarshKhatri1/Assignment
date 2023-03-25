package com.paypal.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.Exception.SprintException;
import com.paypal.Exception.UserException;
import com.paypal.model.Sprint;
import com.paypal.model.User;
import com.paypal.repo.SprintDao;
import com.paypal.repo.UserDao;


@Service
public class SprintServiceImpl implements SprintService{
	
	@Autowired
	private SprintDao sprintDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	UserService userService;

	@Override
	public List<com.paypal.model.Task> Task(Integer id) throws SprintException {
		
	 Optional<Sprint> sprint = 	sprintDao.findById(id);
	 
	 if(sprint.isEmpty()) {
		 throw new SprintException("Invalid id");
	 }
		List<com.paypal.model.Task>  list = sprint.get().getTaskList();
		return list;
	}

	@Override
	public Sprint addSpring(Sprint sprint) throws SprintException {
		// TODO Auto-generated method stub
		
		return sprintDao.save(sprint);
	}

	@Override
	public Sprint addTask(Integer SprintID,Integer userID, com.paypal.model.Task task) throws SprintException, UserException {
		// TODO Auto-generated method stub
		Optional<Sprint> sprint =  sprintDao.findById(SprintID);
		if(sprint.isEmpty()) {
			throw new SprintException("sprint not found with id " + SprintID);
		}
		sprint.get().getTaskList().add(task);
		
		Optional<User> user =  userDao.findById(userID);
		 if(user.isEmpty()) {
			 throw new UserException("user not found with id " + userID);
		 }
		
	 User user1= 	userService.addTask(userID, task);
	 
		
		return sprintDao.save(sprint.get());
	}

	

}

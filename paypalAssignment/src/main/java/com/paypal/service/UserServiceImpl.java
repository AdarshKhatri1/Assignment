package com.paypal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.Exception.UserException;
import com.paypal.model.User;
import com.paypal.repo.UserDao;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public User AddUser(User user) throws UserException {
		// TODO Auto-generated method stub
	User user1 =	userDao.findByMobileNo(user.getMobileNo());
	if(user1!=null) {
		throw new UserException("User already added with this mobile number");
	}
		return userDao.save(user);
	}

	@Override
	public List<com.paypal.model.Task> Task(Integer id) throws UserException {
		// TODO Auto-generated method stub 
		 Optional<User> user =  userDao.findById(id);
		 if(user.isEmpty()) {
			 throw new UserException("user not found with id " + id);
		 }
		 
		return user.get().getList();
	}

	@Override
	public User addTask( Integer UserID, com.paypal.model.Task task) throws UserException {
		Optional<User> user =  userDao.findById(UserID);
		 if(user.isEmpty()) {
			 throw new UserException("user not found with id " + UserID);
		 }
		 
User user1 = user.get();

user.get().getList().add(task);
		
		return user1;
		
	}

}

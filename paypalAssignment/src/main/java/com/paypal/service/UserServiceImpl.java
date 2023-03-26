package com.paypal.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.paypal.Exception.UserException;
import com.paypal.dto.UserTaskDto;
import com.paypal.model.User;
import com.paypal.repo.UserDao;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	@Override
	public User AddUser(User user) throws UserException {
		// TODO Auto-generated method stub
		
		User getUser = userDao.findByUserMobileNo(user.getUserMobileNo());
		                                                
		if(getUser!= null) {
			throw new UserException("User already registered with this mobile no " +user.getUserMobileNo());
		}
		           
		return userDao.save(user);
	}

	@Override
	public List<UserTaskDto> getallTaskofUser(Integer userID) {
		// TODO Auto-generated method stub
		
		Optional<User> user = userDao.findById(userID);
		UserTaskDto userTaskDto = new UserTaskDto();
		
		
		List<UserTaskDto> list = userTaskDto.createUserTaskDto(user.get().getUserTaskList());
		
		return list;
	}
	
}
	

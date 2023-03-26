package com.paypal.service;


import java.util.List;

import com.paypal.Exception.UserException;
import com.paypal.dto.UserTaskDto;
import com.paypal.model.User;

public interface UserService {

	public User AddUser(User user)throws UserException;
	public List<UserTaskDto> getallTaskofUser(Integer userID);

}

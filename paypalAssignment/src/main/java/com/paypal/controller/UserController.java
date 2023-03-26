package com.paypal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.Exception.UserException;
import com.paypal.dto.UserTaskDto;
import com.paypal.model.User;

import com.paypal.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/addUsers")
	public ResponseEntity<User> addUser(@RequestBody User user) throws UserException{
		User user2 = userService.AddUser(user);
		
		return new ResponseEntity<User>(user2,HttpStatus.ACCEPTED);	
		}


	@GetMapping("/getAllTask")
	public ResponseEntity<List<UserTaskDto>> getallTaskofUser(@RequestParam Integer userID){
		
		List<UserTaskDto> list = userService.getallTaskofUser(userID);
		return new ResponseEntity<List<UserTaskDto>>(list,HttpStatus.ACCEPTED);
		
	}
}

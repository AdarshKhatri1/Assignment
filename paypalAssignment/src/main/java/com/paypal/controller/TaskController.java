package com.paypal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.Exception.SprintException;
import com.paypal.Exception.TaskException;
import com.paypal.Exception.UserException;
import com.paypal.dto.TaskDto;
import com.paypal.model.Task;
import com.paypal.service.TaskService;

@RestController
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@PostMapping("/addTask")
	public ResponseEntity<TaskDto>addTask(@RequestBody Task task, @RequestParam Integer sprintID, @RequestParam Integer userID) throws SprintException, UserException {
		
		TaskDto savedTask = taskService.addTask(task, sprintID, userID);
		return new ResponseEntity<TaskDto>(savedTask, HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/deleteTask")
	public ResponseEntity<Boolean> deleteTask(@RequestParam Integer taskID) throws TaskException{
		
		Boolean val = taskService.deleteTask(taskID);
		return new ResponseEntity<Boolean>(val,HttpStatus.ACCEPTED);
	}
	
}

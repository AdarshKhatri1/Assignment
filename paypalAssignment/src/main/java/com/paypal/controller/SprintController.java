package com.paypal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.Exception.SprintException;
import com.paypal.model.Sprint;
import com.paypal.model.Task;
import com.paypal.service.SprintService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class SprintController {
	
	@Autowired
	private SprintService sprintService;
	
	@PostMapping("/addSprint")
	public ResponseEntity<Sprint> addSprint(@RequestBody Sprint sprint) throws SprintException {
		
	Sprint sprint2 = 	sprintService.addSpring(sprint);
		return new ResponseEntity<Sprint>(sprint2,HttpStatus.ACCEPTED);
		
		
	}
	
	@GetMapping("/listoftask")
	public ResponseEntity<List<Task>> Listoftask (@RequestParam Integer id) throws SprintException{
		
		List<Task> list = sprintService.Task(id);
		return new ResponseEntity<List<Task>>(list,HttpStatus.ACCEPTED);
		
	}

}

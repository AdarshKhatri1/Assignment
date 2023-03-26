package com.paypal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.paypal.Exception.SprintException;
import com.paypal.dto.SprintDto;
import com.paypal.model.Sprint;
import com.paypal.service.SprintService;

@RestController
public class SprintController {

	@Autowired
	private SprintService sprintService;

	@PostMapping("/addSprint")
	public ResponseEntity<Sprint> addSprint(@RequestBody Sprint sprint) throws SprintException {

		Sprint sprint1 = sprintService.addSprint(sprint);
		return new ResponseEntity<Sprint>(sprint1, HttpStatus.ACCEPTED);

	}

	@PatchMapping("/updateSprint")
	public ResponseEntity<Sprint> updateSprint(@RequestBody Sprint sprint) throws SprintException {

		Sprint sprint2 = sprintService.updateSprint(sprint);

		return new ResponseEntity<Sprint>(sprint2, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteSprint")
	public ResponseEntity<Boolean> deleteSprint(@RequestParam Integer id) throws SprintException {

		 sprintService.deleteSprint(id);

		return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/allsprintPlan")
	public ResponseEntity<List<SprintDto>> getallsprint(){
		
		List<SprintDto> sprintDtoList = sprintService.getallSprint();
		return new ResponseEntity<List<SprintDto>>(sprintDtoList,HttpStatus.ACCEPTED);
		
	}
	


}

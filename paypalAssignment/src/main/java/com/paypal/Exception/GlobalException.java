package com.paypal.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<Error> userException(UserException userEx,WebRequest web){
		
		Error error = new Error(LocalDateTime.now(),userEx.getMessage(), web.getDescription(false));
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TaskException.class)
	public ResponseEntity<Error> taskException(TaskException taskEx,WebRequest web){
		
		Error error = new Error(LocalDateTime.now(),taskEx.getMessage(), web.getDescription(false));
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(SprintException.class)
	public ResponseEntity<Error> sprintException(SprintException sprintEx,WebRequest web){
		
		Error error = new Error(LocalDateTime.now(),sprintEx.getMessage(), web.getDescription(false));
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Error> Exception(Exception Ex,WebRequest web){
		
		Error error = new Error(LocalDateTime.now(),Ex.getMessage(), web.getDescription(false));
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
}

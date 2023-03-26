package com.paypal.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SprintTaskDto {
	private Integer taskID;
	private String taskName;
	private LocalDate taskdate;
	private Boolean taskStatus;
	
	private UserDto userDto;
}

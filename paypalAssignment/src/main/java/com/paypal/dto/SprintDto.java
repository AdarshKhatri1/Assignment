package com.paypal.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.paypal.model.Sprint;
import com.paypal.model.Task;

import lombok.Data;

@Data
public class SprintDto {
	private Integer sprintID;
	private String sprintName;
	private List<SprintTaskDto> sprintTaskDto;
	
	public List<SprintDto> createSprintDto(List<Sprint> sprintList) {
		
		List<SprintDto> list = new ArrayList<>();
		
		
		for(Sprint s:sprintList) {
			SprintDto sprintDto = new SprintDto();
			sprintDto.setSprintID(s.getSprintID());
			sprintDto.setSprintName(s.getSprintName());
			List<SprintTaskDto> sprintTaskDto2 = new ArrayList<>();

			List<Task> tasklist = s.getTaskList();
			for(Task task:tasklist) {
				SprintTaskDto sprintTaskDtos = new SprintTaskDto();
				sprintTaskDtos.setTaskID(task.getTaskID());
				sprintTaskDtos.setTaskName(task.getTaskName());
				sprintTaskDtos.setTaskdate(task.getTaskdate());
				sprintTaskDtos.setTaskStatus(task.getTaskStatus());
				UserDto userDto = new UserDto();
				userDto.setUserID(task.getUserAssignedToTask().getUserID());
				userDto.setUserName(task.getUserAssignedToTask().getUserName());
				userDto.setUserAddress(task.getUserAssignedToTask().getUserAddress());
				userDto.setUserMobileNo(task.getUserAssignedToTask().getUserMobileNo());
				sprintTaskDtos.setUserDto(userDto);
				sprintTaskDto2.add(sprintTaskDtos);
				
			}
			sprintDto.setSprintTaskDto(sprintTaskDto2);
			list.add(sprintDto);
			
		}
		
		return list;
		
	}
}

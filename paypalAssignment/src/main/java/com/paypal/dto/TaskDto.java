package com.paypal.dto;

import java.time.LocalDate;
import com.paypal.model.Task;


import lombok.Data;

@Data
public class TaskDto {
	private Integer taskID;
	private String taskName;
	private LocalDate taskdate;
	private Boolean taskStatus;
	private TaskSprintDto sprintDto;
	private UserDto userDto;
	
	public  TaskDto createnewdto(Task task) {
		TaskDto taskDto = new TaskDto();
		taskDto.setTaskID(task.getTaskID());
		taskDto.setTaskName(task.getTaskName());
		taskDto.setTaskdate(task.getTaskdate());
		taskDto.setTaskStatus(task.getTaskStatus());
		TaskSprintDto sprint2 = new TaskSprintDto();
		sprint2.setSprintID(task.getSprint().getSprintID());
		sprint2.setSprintName(task.getSprint().getSprintName());
		taskDto.setSprintDto(sprint2);
		UserDto user1 = new UserDto();
		user1.setUserID(task.getUserAssignedToTask().getUserID());
		user1.setUserName(task.getUserAssignedToTask().getUserName());
		user1.setUserAddress(task.getUserAssignedToTask().getUserAddress());
		user1.setUserMobileNo(task.getUserAssignedToTask().getUserMobileNo());
		taskDto.setUserDto(user1);
		return taskDto;
		
	}
}

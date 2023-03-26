package com.paypal.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.paypal.model.Task;

import lombok.Data;

@Data
public class UserTaskDto {
	private Integer taskID;
	private String taskName;
	private LocalDate taskdate;
	private Boolean taskStatus;
	private TaskSprintDto sprintDto;
	
	public List<UserTaskDto> createUserTaskDto(List<Task> list) {
		List<UserTaskDto> listuser = new ArrayList<>();
		for(Task task:list) {
			UserTaskDto userTaskDto = new UserTaskDto();
			userTaskDto.setTaskID(task.getTaskID());
			userTaskDto.setTaskName(task.getTaskName());
			userTaskDto.setTaskStatus(task.getTaskStatus());
			userTaskDto.setTaskdate(task.getTaskdate());
			TaskSprintDto sprint = new TaskSprintDto();
			sprint.setSprintID(task.getSprint().getSprintID());
			sprint.setSprintName(task.getSprint().getSprintName());
			userTaskDto.setSprintDto(sprint);
			listuser.add(userTaskDto);
		}
		return listuser;
		
	}
}

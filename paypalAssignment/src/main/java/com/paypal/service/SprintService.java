package com.paypal.service;


import java.util.List;

import com.paypal.Exception.SprintException;
import com.paypal.dto.SprintDto;
import com.paypal.model.Sprint;

public interface SprintService {
	
	public Sprint addSprint(Sprint sprint) throws SprintException;
	public Sprint updateSprint(Sprint sprint) throws SprintException;
	public Boolean deleteSprint(Integer sprintID) throws SprintException;
	public List<SprintDto>getallSprint();
	public List<String>getallSprint2();
}

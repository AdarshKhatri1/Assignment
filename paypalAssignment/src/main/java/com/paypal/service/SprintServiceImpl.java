package com.paypal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.Exception.SprintException;
import com.paypal.dto.SprintDto;
import com.paypal.model.Sprint;
import com.paypal.repo.SprintDao;

@Service
public class SprintServiceImpl implements SprintService{
	
	@Autowired
	private SprintDao sprintDao;

	@Override
	public Sprint addSprint(Sprint sprint) throws SprintException {

		Sprint sprint1 = sprintDao.save(sprint);
		
		return sprint1;
	}

	@Override
	public Sprint updateSprint(Sprint sprint) throws SprintException {

		Sprint sprint2 = sprintDao.save(sprint);
		
		return sprint2;
	}

	@Override
	public Boolean deleteSprint(Integer sprintID) throws SprintException {

		Optional<Sprint> sprint = sprintDao.findById(sprintID);
		
		if(sprint.isEmpty()) {
			throw new SprintException("No sprint with this ID");
		}
		sprintDao.delete(sprint.get());
		return true;
		
	}

	@Override
	public List<SprintDto> getallSprint() {
		// TODO Auto-generated method stub
		List<Sprint> Sprintlist = sprintDao.findAll();
		System.out.println(Sprintlist.size());
		
		SprintDto sprintDto = new SprintDto();
		
		List<SprintDto> SprintDtoList= sprintDto.createSprintDto(Sprintlist);

		return SprintDtoList;
	}

	@Override
	public List<String> getallSprint2() {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("adarsssh");
		list.add("adarsdfgdfgssh");
		list.add("adardfgdfgsssh");
		list.add("adardfgdfgsssh");
		list.add("adardfgdfgsssh");
		list.add("adardfgdfgsssh");
		return list;
		
	}
	
	

	

}

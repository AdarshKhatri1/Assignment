package com.paypal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Sprint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sprintID;
	
	private String sprintName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sprint")
	private List<Task>  TaskList = new ArrayList<>();
	
	

}

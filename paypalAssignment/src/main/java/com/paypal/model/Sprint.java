package com.paypal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
	private Integer ID;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Task>  TaskList = new ArrayList<>();
	
	

}

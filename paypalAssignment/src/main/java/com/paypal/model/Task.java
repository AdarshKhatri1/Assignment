package com.paypal.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer taskID;
	private String taskName;
	private LocalDate taskdate = LocalDate.now();
	private Boolean taskStatus;	
	
	
	@ManyToOne
	private User userAssignedToTask;
	
	@ManyToOne
	private Sprint sprint;

}

package com.ashokit;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "student")
public class Student {
	@Id
	private Integer studentId;
	private String studentName;
	private String courseName;
	

}

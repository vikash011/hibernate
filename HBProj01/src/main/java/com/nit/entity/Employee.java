package com.nit.entity;

import lombok.Data;

@Data
public class Employee {

	private long empId;
	private String firstName;
	private String lastName;
	private String job;
	private double salary;

}

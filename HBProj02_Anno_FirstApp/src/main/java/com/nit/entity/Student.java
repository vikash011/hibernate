package com.nit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StudentInfo")
public class Student {

	@Id
	@Column(name = "sId")
	private int id;

	@Column(name = "sname")
	private String name;

	@Column(name = "smarks")
	private double marks;

	@Column(name = "sAddr")
	private String addres;

	public Student() {
		System.out.println("Student.Student()");
	}

	public int getId() {
		System.out.println("Student.getId()");
		return id;
	}

	public void setId(int id) {
		System.out.println("Student.setId()");
		this.id = id;
	}

	public String getName() {
		System.out.println("Student.getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println("Student.setName()");
		this.name = name;
	}

	public double getMarks() {
		System.out.println("Student.getMarks()");
		return marks;
	}

	public void setMarks(double marks) {
		System.out.println("Student.setMarks()");
		this.marks = marks;
	}

	public String getAddres() {
		System.out.println("Student.getAddres()");
		return addres;
	}

	public void setAddres(String addres) {
		System.out.println("Student.setAddres()");
		this.addres = addres;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks=" + marks + ", addres=" + addres + "]";
	}

	
	
}

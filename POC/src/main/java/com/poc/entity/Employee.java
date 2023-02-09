package com.poc.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employee {

	@Id
	private int id;

	private String name;

	private String gender;

//	@ManyToOne( cascade=CascadeType.ALL,fetch = FetchType.EAGER)
//
//	private Department department;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	

//	public Department getDepartment() {
//		return department;
//	}
//
//	public void setDepartment(Department department) {
//		this.department = department;
//	}


//	public Employee(int id, String name, String gender, Department department) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.gender = gender;
//		this.department = department;
//	}
	

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name, String gender) {
	super();
	this.id = id;
	this.name = name;
	this.gender = gender;
}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + "]";
	}

//	@Override
//	public String toString() {
//		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", department=" + department + "]";
//	}

	
}

package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "Paging_Table")
public class Employee {
	
	@EmbeddedId
	private Department department;

	private String empname;

	private String gender;

//	@ManyToOne( cascade=CascadeType.ALL,fetch = FetchType.EAGER)
//

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, String gender, Department department) {
		super();
		this.empname = name;
		this.gender = gender;
		this.department = department;

	}

	@Override
	public String toString() {
		return "Employee [name=" + empname + ", gender=" + gender + ", department=" + department + "]";
	}

}

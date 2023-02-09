package com.poc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Department {
	
	@Id
	private int depId;
	
	private String deptName;
	
	//@OneToMany( cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@OneToMany( cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="DeptId")
	private List<Employee> emplist;

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Employee> getEmplist() {
		return emplist;
	}

	public void setEmplist(List<Employee> emplist) {
		this.emplist = emplist;
	}

	public Department(int depId, String deptName, List<Employee> emplist) {
		super();
		this.depId = depId;
		this.deptName = deptName;
		this.emplist = emplist;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Department [depId=" + depId + ", deptName=" + deptName + ", emplist=" + emplist + "]";
	}
	
	
	

}

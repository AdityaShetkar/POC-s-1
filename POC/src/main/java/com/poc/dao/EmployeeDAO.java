package com.poc.dao;

import com.poc.entity.Department;
import com.poc.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EmployeeDAO {
    public void addEmployee(Employee employee);

    public List<Employee> getAllEmployee();
    public  Employee getEmployeeById(int id);
    public void deleteEmployee(int id);
	public void updateEmployee(Employee employee);
	
	public void addDept(Department department);
	public Object criteriaByName();

    public Object criteria(int id);
    
}

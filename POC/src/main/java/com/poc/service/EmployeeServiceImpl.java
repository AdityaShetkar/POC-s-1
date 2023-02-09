package com.poc.service;

import com.poc.dao.EmployeeDAO;
import com.poc.entity.Department;
import com.poc.entity.Employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeDAO employeeDAO;
    
//    @Autowired
//    EmployeeRepo employeeRepo;
    @Transactional
    @Override
    public List<Employee> get() {
        return employeeDAO.getAllEmployee();
    }

    @Transactional
    @Override
    public Employee get(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Transactional
    @Override
    public void save(Employee employee) {
        employeeDAO.addEmployee(employee);
    }

    @Transactional
    @Override
    public void delete(int id) {
        employeeDAO.deleteEmployee(id);
    }

	@Override
	public Employee update( Employee employee) {
		// TODO Auto-generated method stub
		
		employeeDAO.updateEmployee(employee);
		return null;
	}

	@Override
	public void save(Department dept) {
		// TODO Auto-generated method stub
		employeeDAO.addDept(dept);
	}
	
	 @Override
	    public Object criteriaByName() {
	        return employeeDAO.criteriaByName();
	    }

	    @Override
	    public Object criteria(int id) {
	        return employeeDAO.criteria(id)
	;
	    }
	    
	   // @Transactional
//	    @Override
//	    public List<Employee> getPagi() {
//	       // return employeeDAO.getAllEmployee();
//	    	List<Employee> emplist= employeeRepo.findAll();
//	    	return emplist;
//	    }
}

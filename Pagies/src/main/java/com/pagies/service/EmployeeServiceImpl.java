package com.pagies.service;

import com.pagies.entity.Employee;
import com.pagies.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public void save(Employee employee) {
        this.employeeRepo.save(employee);
    }

    public List<Employee> listAll() {
        return this.employeeRepo.findAll();
    }

    public void deleteEmployee(int id) {
        this.deleteEmployee(id);
    }

    public Employee getById(int id) {
        return this.getById(id);
    }

    @Override
    public List<Employee> getPagies() {
        int pageSize = 5;
        int pageNumber = 1;

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Employee> pagepost = employeeRepo.findAll(pageable);
        List<Employee> content = pagepost.getContent();
        return content;
    }

//    public List<Employee> updateEmployeeById(Employee employee, int id) {
//        return this.employeeRepo.findById(id);
//


//    public Employee get(int id) {
//        return employeeRepo.findAllById(id);
//    }
//
//
//    public void save(Employee employee) {
//        //.addEmployee(employee);
//        employeeRepo.save(employee);
//    }
//
//
//    public void delete(int id) {
////	        employeeDAO.deleteEmployee(id);
//
//        employeeRepo.deleteById(id);
//    }
//
//    @Override
//    public Employee updateEmployee(int id) {
//        return null;
//    }
//
//    @Override
//    public List<Employee> getPagies(){
//        int pageSize = 5;
//        int pageNumber = 1;
//
//        Pageable pageable = PageRequest.of(pageNumber, pageSize);
//        Page<Employee> pagepost = employeeRepo.findAll(pageable);
//        List<Employee> content = pagepost.getContent();
//        return content;
//    }
}


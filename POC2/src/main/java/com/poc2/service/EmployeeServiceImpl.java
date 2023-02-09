package com.poc2.service;

import com.poc2.model.Employee;
import com.poc2.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getAll() {
        return this.employeeRepo.findAll();
    }

    @Override
    public Optional<Employee> getById(int employeeCode) {
        return this.employeeRepo.findById(employeeCode);
    }

    @Override
    public void save(Employee employee) {
        this.employeeRepo.save(employee);
    }

    @Override
    public void delete(int employeeCode) {
        this.employeeRepo.deleteById(employeeCode);
    }

    @Override
    public Employee update(Employee employee, int employeeCode) {
        Employee employee1 = this.employeeRepo.findById(employeeCode).get();

        employee1.setName(employee.getName());
        employee1.setAge(employee.getAge());
        employee1.setGender(employee.getGender());

        Employee updatedEmployee = this.employeeRepo.save(employee1);
        return updatedEmployee;
    }

    @Override
    public Optional<Employee> getByName(String name) {
        return this.employeeRepo.getByName(name);
    }

    @Override
    public List<Employee> listByAgeGreaterThanEqual(int age) {
        return this.employeeRepo.findByAgeGreaterThanEqual(age);
    }

    @Override
    public List<Employee> findByAgeBetween(int start, int end) {
        return this.employeeRepo.findByAgeBetween(start, end);
    }

    @Override
    public List<Employee> findByOrderByAgeDesc() {
        List<Employee> employees = this.employeeRepo.findByOrderByAgeDesc();
        return employees;
    }

    @Override
    public List<Employee> findByOrderByAgeAsc() {
        List<Employee> employees = this.employeeRepo.findByOrderByAgeAsc();
        return employees;
    }

    @Override
    public List<Employee> paging(int pageNumber, int pageSize) {
        Page<Employee> employees = this.employeeRepo.findAll(PageRequest.of(pageNumber, pageSize));
        List list = employees.toList();
        return list;
    }

    @Override
    public List<Employee> sortByName() {
        List<Employee> employees = this.employeeRepo.findAll(Sort.by(Sort.Direction.ASC, "name"));
        return employees;
    }

    @Override
    public List<Employee> findAllEmployeesByPagination() {
        return this.employeeRepo.findAllEmployeesByPagination();
    }

    @Override
    public List<Employee> findByNameOrGender(String name, String gender) {
        List<Employee> employees = this.employeeRepo.findByNameOrGender(name, gender);
        return employees;
    }

    @Override
    public Employee findByEmployeeCodeJPQL(int employeeCode) {
        Employee employee = this.employeeRepo.findByEmployeeCodeJPQL(employeeCode);
        return employee;
    }

}

package com.poc2.controller;


import com.poc2.model.Employee;
import com.poc2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public void add(@RequestBody Employee employee){
        this.employeeService.save(employee);
    }

    @GetMapping("/listAll")
    public List<Employee> listAll(){
        List<Employee> departments = this.employeeService.getAll();
        return departments;
    }

    @GetMapping("/getById")
    public Optional<Employee> getById(@RequestParam int employeeCode){
        Optional<Employee> employee = this.employeeService.getById(employeeCode);
        return employee;
    }

    @DeleteMapping("/delete")
    public String deleteById(@RequestParam int employeeCode){
        Optional<Employee> department = this.employeeService.getById(employeeCode);
        this.employeeService.delete(employeeCode);
        return "Employee has been deleted successfully with employee code " + employeeCode;
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee, @RequestParam int employeeCode){
        Employee updatedEmployee = this.employeeService.update(employee, employeeCode);
        return updatedEmployee;
    }

    @GetMapping("/getByName")
    public Optional<Employee> getEmployeeByName(@RequestParam String name){
        Optional<Employee> employee = this.employeeService.getByName(name);
        return employee;
    }

    @GetMapping("/listByAgeGreaterThanEqual")
    public List<Employee> listByAgeGreaterThanEqual(@RequestParam int age){
        List<Employee> employeeList = this.employeeService.listByAgeGreaterThanEqual(age);
        return employeeList;
    }

    @GetMapping("/findByAgeBetween")
    public List<Employee> findByAgeBetween(@RequestParam int start,@RequestParam int end){
        List<Employee> employees = this.employeeService.findByAgeBetween(start, end);
        return employees;
    }

    @GetMapping("/findbyOrderByAgeDesc")
    public List<Employee> findAllOrderByAgeDesc(){
        List<Employee> employees = this.employeeService.findByOrderByAgeDesc();
        return employees;
    }

    @GetMapping("/findByOrderByAgeAsc")
    public List<Employee> findByNameOrderByAgeAsc(){
        List<Employee> employees = this.employeeService.findByOrderByAgeAsc();
        return employees;
    }

    @GetMapping("/paging")
    public List<Employee> listAll(@RequestParam int pageNumber, @RequestParam int pageSize){
        return employeeService.paging(pageNumber, pageSize);
    }

    @GetMapping("/sortedByName")
    public List<Employee> sortedByName(){
        List<Employee> employees = this.employeeService.sortByName();
        return employees;
    }

    @GetMapping("/nativeEmployee")
    public List<Employee> nativeEmployee(){
       List<Employee> employees = this.employeeService.findAllEmployeesByPagination();
       return employees;
    }

    @GetMapping("/JPQL")
    public List<Employee> getByJPQL(@RequestParam String name, @RequestParam String gender){
        return this.employeeService.findByNameOrGender(name, gender);
    }

    @GetMapping("/getByEmployeeCodeJPQL")
    public Employee getByEmployeeCodeJPQL(@RequestParam int employeeCode){
        return this.employeeService.findByEmployeeCodeJPQL(employeeCode);
    }

}


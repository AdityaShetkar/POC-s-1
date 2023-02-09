package com.poc.controller;

import com.poc.entity.Department;
import com.poc.entity.Employee;
import com.poc.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @GetMapping("/getAll")
    public List<Employee> get(){
        return employeeServiceImpl.get();
    }

    @PostMapping("/add")
    public Employee save(@RequestBody Employee employeeObj){
        employeeServiceImpl.save(employeeObj);
        return employeeObj;
    }

    @GetMapping("/getById/{id}")
    public  Employee get(@PathVariable int id){
        Employee employeeObj = employeeServiceImpl.get(id);
        if (employeeObj == null){
            throw new RuntimeException("Employee with id " + id + " is not found");
        }
        return employeeServiceImpl.get(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        employeeServiceImpl.delete(id);
        return "Employee has been deleted with id: " + id;
    }
    
    @Transactional
    @PutMapping("/update/{id}")
    public Employee update(@PathVariable int id,@RequestBody Employee employeeObj) {
    	
    	
    	Employee oldemp =  employeeServiceImpl.get(id);
//    	employeeServiceImpl.update(employeeObj);
//    	
    	//stud.setStudent_name(student.getStudent_name());
    	System.out.println("Hellooo");
    	oldemp.setName(employeeObj.getName());
    	oldemp.setGender(employeeObj.getGender());
    //	oldemp.setDepartment(employeeObj.getDepartment());
    	
    	employeeServiceImpl.update(oldemp);
    	
    	return oldemp;
    }
    
    @Transactional
    @PostMapping("/addDept")
    public Department save(@RequestBody Department dept){
    	dept.setDepId(dept.getDepId());
        employeeServiceImpl.save(dept);
        return dept;
    }
    
    @GetMapping("/hcqlName")
    public Object criteriaByName() {
        return employeeServiceImpl.criteriaByName();
    }

    @GetMapping("/hcqlId/{id}")
    public Object criteria(@PathVariable int id) {
        return employeeServiceImpl.criteria(id);
    }
    
//    @GetMapping("/getAllPagi")
//    public List<Employee> getPagi(){
//        return employeeServiceImpl.get();
//    }

    
}

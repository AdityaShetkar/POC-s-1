package com.pagies.controller;

import com.pagies.entity.Employee;
import com.pagies.repo.EmployeeRepo;
import com.pagies.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired(required = true)
    private EmployeeRepo employeeRepo;

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/save")
    public Employee saveEmp(@RequestBody Employee employee){
        this.employeeServiceImpl.save(employee);
        return employee;
    }

    @GetMapping("/getById/{id}")
    public Employee getById(@PathVariable("id") int id){
        Employee employee = this.employeeServiceImpl.getById(id);
        return employee;
    }

    @DeleteMapping("delete/{id}")
    public void deleteEmp(@PathVariable("id") int id){
        Optional<Employee> employee = this.employeeRepo.findAllById(id);
        this.employeeServiceImpl.deleteEmployee(id);
    }

    @GetMapping("/getAll")
    public List<Employee> get(){
        return employeeServiceImpl.getPagies();
    }


//    @GetMapping("/getAll")
//    public List<Employee> get() {
//        return employeeServiceImpl.getPagies();
//    }
//
//    @PostMapping("/add")
//    public Employee save(@RequestBody Employee employeeObj) {
//        employeeServiceImpl.save(employeeObj);
//        return employeeObj;
//    }
//
//    @GetMapping("/getById/{id}")
//    public Employee get(@PathVariable int id) {
//        Employee employeeObj = employeeServiceImpl.get(id);
//        if (employeeObj == null) {
//            throw new RuntimeException("Employee with id " + id + " is not found");
//        }
//        return employeeServiceImpl.get(id)
//                ;
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public String delete(@PathVariable int id) {
//        employeeServiceImpl.delete(id)
//        ;
//        return "Employee has been deleted with id: " + id;
//    }
//
//    @Transactional
//    @PutMapping("/update/{id}")
//    public Employee update(@PathVariable int id,@RequestBody Employee employeeObj) {
//
//
//        Employee oldemp =  employeeServiceImpl.get(id)
//                ;
////    	employeeServiceImpl.update(employeeObj);
////
//        //stud.setStudent_name(student.getStudent_name());
//        System.out.println("Hellooo");
//        oldemp.setName(employeeObj.getName());
//        oldemp.setGender(employeeObj.getGender());
//        //	oldemp.setDepartment(employeeObj.getDepartment());
//
//        employeeServiceImpl.updateEmployee(id);
//
//        return oldemp;
//    }

}


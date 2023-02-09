package com.poc2.service;

import com.poc2.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getAll();

   Optional<Employee> getById(int employeeCode);

    void save(Employee employee);

    void delete(int id);

    Employee update(Employee employee, int employeeCode);

    Optional<Employee> getByName(String name);

    List<Employee> listByAgeGreaterThanEqual(int age);

    List<Employee> findByAgeBetween(int start, int end);

    List<Employee> findByOrderByAgeDesc();

    List<Employee> findByOrderByAgeAsc();

    List<Employee> paging(int pageNumber, int pageSize);

    List<Employee> sortByName();

    List<Employee> findAllEmployeesByPagination();

    List<Employee> findByNameOrGender(String name, String gender);

    Employee findByEmployeeCodeJPQL(int employeeCode);

}

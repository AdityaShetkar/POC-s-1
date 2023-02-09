package com.poc2.repo;


import com.poc2.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    public Optional<Employee> getByName(String name);

    List<Employee> findByAgeGreaterThanEqual(int age);

    List<Employee> findByAgeBetween(int start, int end);

    List<Employee> findByOrderByAgeDesc();

    List<Employee> findByOrderByAgeAsc();

    @Query(
            value = "SELECT * FROM employee_info ORDER BY employee_code",
            countQuery = "SELECT count(*) FROM Employee",
            nativeQuery = true)
    List<Employee> findAllEmployeesByPagination();

    @Query(value = "select e from Employee e where e.name =:name or e.gender=:gender")
    List<Employee> findByNameOrGender(@Param("name") String name, @Param("gender") String gender);

    @Query(value = "select e from Employee e where e.employeeCode =:employeeCode")
    Employee findByEmployeeCodeJPQL(@Param("employeeCode") int employeeCode);


}

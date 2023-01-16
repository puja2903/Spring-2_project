package com.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeemanager.model.Employee;

import java.util.Optional;

/* Repository for Employee operations */
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    /*
      Delete an Employee by id
     */
    void deleteEmployeeById(Long id);

    // Find Employee by id
     
    Optional<Employee> findEmployeeById(Long id);
}
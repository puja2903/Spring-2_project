package com.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanager.exception.UserNotFoundException;
import com.employeemanager.model.Employee;
import com.employeemanager.repo.EmployeeRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

//* Service class for Employee operations
 
@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    //* Constructor for EmployeeService
    
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    // Add a new Employee
    
    public Employee addEmployee(Employee employee) {
        // generate unique code for employee
        employee.setEmployeeCode(UUID.randomUUID().toString());
        // save employee to repository
        return employeeRepo.save(employee);
    }

   // Find all Employees
     
    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    // Update an existing Employee
     
    public Employee updateEmployee(Employee employee) {
        // save employee to repository
        return employeeRepo.save(employee);
    }

    // Find Employee by id
     
    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    // Delete an Employee by id
     
    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }
}
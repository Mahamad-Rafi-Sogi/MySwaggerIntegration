package com.rafi.swagger.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rafi.swagger.entity.Employee;
import com.rafi.swagger.service.EmployeeService;
import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Employee Management", description = "APIs for managing employees")
public class EmployeeController {  

    @Autowired
    private EmployeeService employeeService;

    // Original hello endpoint
    @GetMapping("/hello")
    public String myFunction() {
        System.out.println("welcome to Rafi Page..!!!");
        return "welcome to Rafi Page..!!!";
    }

    // Employee management endpoints
    @PostMapping("/employees")
    @Operation(summary = "Create a new employee", description = "Creates a new employee record")
    @ApiResponse(responseCode = "200", description = "Employee created successfully")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/employees")
    @Operation(summary = "Get all employees", description = "Returns list of all employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    @Operation(summary = "Get employee by ID", description = "Returns a single employee")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/employees/{id}")
    @Operation(summary = "Update an employee", description = "Updates an existing employee record")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        try {
            Employee updatedEmployee = employeeService.updateEmployee(id, employee);
            return ResponseEntity.ok(updatedEmployee);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/employees/{id}")
    @Operation(summary = "Delete an employee", description = "Deletes an employee record")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        try {
            employeeService.deleteEmployee(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
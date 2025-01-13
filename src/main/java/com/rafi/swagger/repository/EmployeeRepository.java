package com.rafi.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rafi.swagger.entity.Employee;

@Repository  // Add this annotation
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
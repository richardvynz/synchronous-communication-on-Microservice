package com.richardvinz.employeeservice.repository;

import com.richardvinz.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findEmployeeById(Long id);
}

package com.richardvinz.employeeservice.service;

import com.richardvinz.employeeservice.dto.ApiResponseDto;
import com.richardvinz.employeeservice.dto.EmployeeDto;
import com.richardvinz.employeeservice.entity.Employee;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    ApiResponseDto getEmployeeById(Long employeeId);
}

package com.richardvinz.employeeservice.controller;

import com.richardvinz.employeeservice.dto.ApiResponseDto;
import com.richardvinz.employeeservice.dto.EmployeeDto;
import com.richardvinz.employeeservice.entity.Employee;
import com.richardvinz.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> SaveEmployee(@RequestBody EmployeeDto employee){
       EmployeeDto savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto>getEmployee(@PathVariable("id") Long employeeId){
       return new ResponseEntity<>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);
    }
}

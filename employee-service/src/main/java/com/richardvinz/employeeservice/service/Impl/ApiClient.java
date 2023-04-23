package com.richardvinz.employeeservice.service.Impl;

import com.richardvinz.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "localhost:8080", value = "DEPARTMENT-SERVICE")
public interface ApiClient {
    @GetMapping("/api/department/{departmentCode}")
    DepartmentDto getDepartment(@PathVariable String  departmentCode);
}

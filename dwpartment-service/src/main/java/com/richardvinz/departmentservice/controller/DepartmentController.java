package com.richardvinz.departmentservice.controller;

import com.richardvinz.departmentservice.dto.DepartmentDto;
import com.richardvinz.departmentservice.entity.Department;
import com.richardvinz.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody Department department){
        DepartmentDto savedDepartment = departmentService.saveDepartment(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/{departmentCode}")
    public ResponseEntity<DepartmentDto>getDepartment(@PathVariable String  departmentCode){
        DepartmentDto departmentDto = departmentService.getDepartmentByDepartmentCode(departmentCode);
        return new ResponseEntity<>(departmentDto,HttpStatus.OK);
    }
}

package com.richardvinz.departmentservice.service;

import com.richardvinz.departmentservice.dto.DepartmentDto;
import com.richardvinz.departmentservice.entity.Department;

public interface DepartmentService {
    DepartmentDto saveDepartment(Department department);

    public DepartmentDto getDepartmentByDepartmentCode(String departmentCode);
}

package com.richardvinz.departmentservice.repository;

import com.richardvinz.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Department findByDepartmentCode(String departmentCode);

//    Department findByDepartmentId(Long departmentId);
}

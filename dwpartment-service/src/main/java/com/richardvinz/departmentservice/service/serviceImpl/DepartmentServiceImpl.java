package com.richardvinz.departmentservice.service.serviceImpl;

import com.richardvinz.departmentservice.dto.DepartmentDto;
import com.richardvinz.departmentservice.entity.Department;
import com.richardvinz.departmentservice.repository.DepartmentRepository;
import com.richardvinz.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto saveDepartment(Department department) {


        Department department1 = departmentRepository.save(department);
        DepartmentDto departmentDto = new DepartmentDto();
        BeanUtils.copyProperties(department1,departmentDto);
        return departmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByDepartmentCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDto departmentDto = new DepartmentDto(
                department.getDepartmentId(),
                department.getDepartmentName(),
                department.getDepartmentCode(),
                department.getDepartmentDescription());

        return departmentDto;

    }
}

//    @Override
//    public DepartmentDto getDepartmentByDepartmentId(Long departmentId) {
//        Department department = departmentRepository.findByDepartmentId(departmentId);
//
//        DepartmentDto departmentDto = new DepartmentDto(
//                department.getId(),
//                department.getDepartmentName(),
//                department.getDepartmentCode(),
//                department.getDepartmentDescription());
//
//        return departmentDto;
//    }
//}

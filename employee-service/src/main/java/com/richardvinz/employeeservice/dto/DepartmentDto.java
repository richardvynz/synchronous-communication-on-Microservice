package com.richardvinz.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class DepartmentDto {
    private Long departmentId;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;

}

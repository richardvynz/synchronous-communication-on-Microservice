package com.richardvinz.departmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private Long departmentId;
    private String departmentName;
    private String departmentCode;
    private String departmentDescription;


}

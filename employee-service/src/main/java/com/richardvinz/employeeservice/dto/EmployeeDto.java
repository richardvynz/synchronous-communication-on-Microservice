package com.richardvinz.employeeservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
//    private String departmentId;
    private String departmentCode;
}

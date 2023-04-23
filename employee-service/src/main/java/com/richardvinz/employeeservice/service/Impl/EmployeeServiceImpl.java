package com.richardvinz.employeeservice.service.Impl;

import com.richardvinz.employeeservice.dto.ApiResponseDto;
import com.richardvinz.employeeservice.dto.DepartmentDto;
import com.richardvinz.employeeservice.dto.EmployeeDto;
import com.richardvinz.employeeservice.entity.Employee;
import com.richardvinz.employeeservice.service.EmployeeService;
import com.richardvinz.employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
//    private final RestTemplate restTemplate;
//    private final WebClient webClient;
private final ApiClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );

        Employee saveDEmployee = employeeRepository.save(employee);

        return new EmployeeDto(
                saveDEmployee.getId(),
                saveDEmployee.getFirstName(),
                saveDEmployee.getLastName(),
                saveDEmployee.getEmail(),
                saveDEmployee.getDepartmentCode()
        );
    }

    @Override
    public ApiResponseDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).get();

//        ResponseEntity<DepartmentDto> forEntity =
//                restTemplate.getForEntity("http://localhost:8080/api/department/"
//                + employee.getDepartmentCode(), DepartmentDto.class);
//       DepartmentDto departmentDto = forEntity.getBody();

//         DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8080/api/department/"
//                + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();


        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );
        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        return apiResponseDto;
    }

//    @Override
//    public ApiResponseDto getEmployeeById(Long employeeId) {
//
//        ApiResponseDto apiResponseDto = new ApiResponseDto();
//        Employee employee = employeeRepository.findEmployeeById(employeeId);
//DepartmentDto departmentDto = restTemplate.getForObject("http://localhost:8080/api/department/"
//        + employee.getDepartmentId(), DepartmentDto.class);
//
//        EmployeeDto employeeDto = new EmployeeDto();
//      BeanUtils.copyProperties(employee,employeeDto);
//
//
//        apiResponseDto.setEmployee(employeeDto);
//        apiResponseDto.setDepartment(departmentDto);
//
//        return apiResponseDto;
//    }

}

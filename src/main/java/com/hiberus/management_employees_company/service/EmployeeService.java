package com.hiberus.management_employees_company.service;

import com.hiberus.management_employees_company.dto.CreateEmployeeDTO;
import com.hiberus.management_employees_company.dto.EmployeeDTO;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface EmployeeService {
    String createEmployee(CreateEmployeeDTO employeeDTO, UUID departmentId);
    String deleteEmployee(UUID employeeId);
    List<EmployeeDTO> getEmployeesByDateRange(LocalDate startDate, LocalDate endDate);
    Map<String, Object> getEmployeeWithHighestSalary();
    Map<String, Object> getEmployeeWithLowestAge();
    Long countEmployeesEnteredLastMonth();
    List<EmployeeDTO> getAllEmployees();
}
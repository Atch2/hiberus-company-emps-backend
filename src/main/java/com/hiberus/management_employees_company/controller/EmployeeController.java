package com.hiberus.management_employees_company.controller;

import com.hiberus.management_employees_company.dto.CreateEmployeeDTO;
import com.hiberus.management_employees_company.dto.EmployeeDTO;
import com.hiberus.management_employees_company.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create/{departmentId}")
    @ResponseStatus(HttpStatus.CREATED)
    public String createEmployee(@Valid @RequestBody CreateEmployeeDTO dto, @PathVariable UUID departmentId) {
        return employeeService.createEmployee(dto, departmentId);
    }

    @DeleteMapping("/delete/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteEmployee(@PathVariable UUID employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }

    @GetMapping("/highest-salary")
    public ResponseEntity<Map<String, Object>> getEmployeeWithHighestSalary() {
        return ResponseEntity.ok(employeeService.getEmployeeWithHighestSalary());
    }

    @GetMapping("/lowest-age")
    public ResponseEntity<Map<String, Object>> getEmployeeWithLowestAge() {
        return ResponseEntity.ok(employeeService.getEmployeeWithLowestAge());
    }

    @GetMapping("/count-last-month")
    public ResponseEntity<Long> countEmployeesEnteredLastMonth() {
        return ResponseEntity.ok(employeeService.countEmployeesEnteredLastMonth());
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
}

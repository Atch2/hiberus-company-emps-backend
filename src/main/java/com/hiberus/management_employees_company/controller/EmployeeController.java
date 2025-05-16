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
import java.util.HashMap;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create/{departmentId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Map<String, Object>> createEmployee(@Valid @RequestBody CreateEmployeeDTO dto, @PathVariable UUID departmentId) {
        String message = employeeService.createEmployee(dto, departmentId);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", message);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/delete/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Map<String, Object>> deleteEmployee(@PathVariable UUID employeeId) {
        String message = employeeService.deleteEmployee(employeeId);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", message);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/highest-salary")
    public ResponseEntity<Map<String, Object>> getEmployeeWithHighestSalary() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", employeeService.getEmployeeWithHighestSalary());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/lowest-age")
    public ResponseEntity<Map<String, Object>> getEmployeeWithLowestAge() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", employeeService.getEmployeeWithLowestAge());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/count-last-month")
    public ResponseEntity<Map<String, Object>> countEmployeesEnteredLastMonth() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", employeeService.countEmployeesEnteredLastMonth());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/employees")
    public ResponseEntity<Map<String, Object>> getAllEmployees() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", employeeService.getAllEmployees());
        return ResponseEntity.ok(response);
    }
}

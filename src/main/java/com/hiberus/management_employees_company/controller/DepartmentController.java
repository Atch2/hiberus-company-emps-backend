package com.hiberus.management_employees_company.controller;

import com.hiberus.management_employees_company.dto.CreateDepartamentDTO;
import com.hiberus.management_employees_company.dto.DepartmentDTO;
import com.hiberus.management_employees_company.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.UUID;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Map<String, Object>> createDepartment(@Valid @RequestBody CreateDepartamentDTO dto) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", departmentService.createDepartment(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/delete/{departmentId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Map<String, Object>> deleteDepartment(@PathVariable UUID departmentId) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", departmentService.deleteDepartment(departmentId));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/departments")
    public ResponseEntity<Map<String, Object>> getAllDepartments() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", departmentService.getAllDepartments());
        return ResponseEntity.ok(response);
    }
}

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

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> createDepartment(@Valid @RequestBody CreateDepartamentDTO dto) {
        return departmentService.createDepartment(dto);
    }

    @DeleteMapping("/delete/{departmentId}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> deleteDepartment(@PathVariable UUID departmentId) {
        return departmentService.deleteDepartment(departmentId);
    }

    @GetMapping("/departments")
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }
}

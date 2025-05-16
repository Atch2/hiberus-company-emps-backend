package com.hiberus.management_employees_company.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.hiberus.management_employees_company.dto.CreateDepartamentDTO;
import com.hiberus.management_employees_company.dto.DepartmentDTO;

public interface DepartmentService {
    Map<String, Object> createDepartment(CreateDepartamentDTO departmentDTO);
    Map<String, Object> deleteDepartment(UUID departmentId);
    List<DepartmentDTO> getAllDepartments();
}

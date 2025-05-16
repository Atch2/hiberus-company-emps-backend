package com.hiberus.management_employees_company.service;

import java.util.List;
import java.util.UUID;

import com.hiberus.management_employees_company.dto.CreateDepartamentDTO;
import com.hiberus.management_employees_company.dto.DepartmentDTO;

public interface DepartmentService {
    String createDepartment(CreateDepartamentDTO departmentDTO);
    String deleteDepartment(UUID departmentId);
    List<DepartmentDTO> getAllDepartments();
}

package com.hiberus.management_employees_company.service.implementation;

import com.hiberus.management_employees_company.dto.CreateDepartamentDTO;
import com.hiberus.management_employees_company.dto.DepartmentDTO;
import com.hiberus.management_employees_company.entity.Department;
import com.hiberus.management_employees_company.repository.DepartmentRepository;
import com.hiberus.management_employees_company.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Map<String, Object> createDepartment(CreateDepartamentDTO departmentDTO) {
        if (departmentRepository.findByName(departmentDTO.getName()).isPresent()) {
            throw new IllegalArgumentException("Ya existe un departamento con ese nombre");
        }
        Department department = new Department();
        department.setName(departmentDTO.getName());
        department.setStatus(departmentDTO.getStatus());

        Department saved = departmentRepository.save(department);
        Map<String, Object> response = new HashMap<>();
        response.put("id", saved.getId());
        response.put("message", "Departamento creado con éxito");
        response.put("department", convertToDTO(saved));
        return response;
    }

    @Override
    public Map<String, Object> deleteDepartment(UUID departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new NoSuchElementException("Department not found with id: " + departmentId));
        department.setStatus("I");
        Department updated = departmentRepository.save(department);
        Map<String, Object> response = new HashMap<>();
        response.put("id", updated.getId());
        response.put("message", "Departamento eliminado con éxito");
        response.put("department", convertToDTO(updated));
        return response;
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private DepartmentDTO convertToDTO(Department department) {
        DepartmentDTO dto = new DepartmentDTO();
        dto.setId(department.getId());
        dto.setName(department.getName());
        dto.setStatus(department.getStatus());
        return dto;
    }
}

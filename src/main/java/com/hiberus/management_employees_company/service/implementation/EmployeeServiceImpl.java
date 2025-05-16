package com.hiberus.management_employees_company.service.implementation;

import com.hiberus.management_employees_company.dto.CreateEmployeeDTO;
import com.hiberus.management_employees_company.dto.EmployeeDTO;
import com.hiberus.management_employees_company.entity.Department;
import com.hiberus.management_employees_company.entity.Employee;
import com.hiberus.management_employees_company.repository.DepartmentRepository;
import com.hiberus.management_employees_company.repository.EmployeeRepository;
import com.hiberus.management_employees_company.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public String createEmployee(CreateEmployeeDTO dto, UUID departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new NoSuchElementException("Department not found with id: " + departmentId));

        Employee employee = new Employee();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setAge(dto.getAge());
        employee.setRole(dto.getRole());
        employee.setSalary(dto.getSalary());
        employee.setStartDate(dto.getStartDate());
        employee.setEndDate(dto.getEndDate());
        employee.setStatus(dto.getStatus());
        employee.setDepartment(department);

        Employee saved = employeeRepository.save(employee);
        dto.setId(saved.getId());
        return "Created employee successfully";
    }

    @Override
    public String deleteEmployee(UUID employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NoSuchElementException("Employee not found with id: " + employeeId));
        employee.setStatus("I");
        employeeRepository.save(employee);
        return "Employee deleted successfully";
    }

    @Override
    public Map<String, Object> getEmployeeWithHighestSalary() {
        Optional<Employee> opt = employeeRepository.findAll().stream()
                .max(Comparator.comparing(Employee::getSalary));
        if (opt.isPresent()) {
            Employee e = opt.get();
            return Map.of("name", e.getFirstName() + " " + e.getLastName(), "salary", e.getSalary());
        }
        return Collections.emptyMap();
    }

    @Override
    public Map<String, Object> getEmployeeWithLowestAge() {
        Optional<Employee> opt = employeeRepository.findAll().stream()
                .min(Comparator.comparing(Employee::getAge));
        if (opt.isPresent()) {
            Employee e = opt.get();
            return Map.of("name", e.getFirstName() + " " + e.getLastName(), "age", e.getAge());
        }
        return Collections.emptyMap();
    }

    @Override
    public Long countEmployeesEnteredLastMonth() {
        LocalDate now = LocalDate.now();
        LocalDate oneMonthAgo = now.minus(1, ChronoUnit.MONTHS);
        return employeeRepository.findByStartDateBetween(oneMonthAgo, now).stream().count();
    }

    @Override
    public List<EmployeeDTO> getEmployeesByDateRange(LocalDate startDate, LocalDate endDate) {
        return employeeRepository.findByStartDateBetween(startDate, endDate)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private EmployeeDTO convertToDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setAge(employee.getAge());
        dto.setRole(employee.getRole());
        dto.setSalary(employee.getSalary());
        dto.setStartDate(employee.getStartDate());
        dto.setEndDate(employee.getEndDate());
        dto.setStatus(employee.getStatus());
        dto.setDepartmentId(employee.getDepartment().getId());
        return dto;
    }
}

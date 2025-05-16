package com.hiberus.management_employees_company.repository;

import com.hiberus.management_employees_company.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    List<Employee> findByStartDateBetween(LocalDate startDate, LocalDate endDate);
}

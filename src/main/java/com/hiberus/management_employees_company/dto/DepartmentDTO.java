package com.hiberus.management_employees_company.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class DepartmentDTO {
    private UUID id;
    private String name;
    private String status;
}

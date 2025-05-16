package com.hiberus.management_employees_company.dto;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CreateDepartamentDTO {
    @NotBlank(message = "No puede estar vacio")
    @NotNull(message = "La edad es obligatoria")
    @Size(min = 2, max = 20, message = "El nombre del departamento debe tener entre 2 y 20 caracteres")
    private String name;

    @NotBlank(message = "No puede estar vacio")
    @NotNull(message = "La edad es obligatoria")
    @Pattern(regexp = "^[AI]$", message = "El estado debe ser 'A' (Activo) o 'I' (Inactivo)")
    private String status;
}

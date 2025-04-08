package com.gestionviajes.msgestionviajes.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DuenioDto {
    @NotBlank(message = "Nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "Apellidos son obligatorios")
    private String apellidos;

    @NotBlank(message = "Correo es obligatorio")
    @Email(message = "Debe ser un correo válido")
    private String correo;

    @NotBlank(message = "Teléfono es obligatorio")
    @Pattern(regexp = "\\d{7,15}", message = "El teléfono debe contener solo números y tener entre 7 y 15 dígitos")
    private String teléfono;

    private String dirección;
}

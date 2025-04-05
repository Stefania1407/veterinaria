package com.gestionviajes.msgestionviajes.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class VeterinarioDto {
    @NotBlank(message = "Nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "Apellidos son obligatorios")
    private String apellidos;
    private String especialización;
    @NotBlank(message = "Correo es obligatorio")
    @Email(message = "Debe ser un correo válido")
    private String correo;
    @NotBlank(message = "Teléfono es obligatorio")
    private int telefono;


}

package com.gestionviajes.msgestionviajes.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class HistorialMedicoDto {
    @NotBlank(message = "Diagnóstico es obligatorio")
    private String diagnóstico;
    @NotBlank(message = "Tratamiento es obligatorio")
    private String tratamiento;
    private String medicación;
    private String notas;
}

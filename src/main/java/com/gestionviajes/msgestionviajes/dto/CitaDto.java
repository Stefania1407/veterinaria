package com.gestionviajes.msgestionviajes.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class CitaDto {
    @NotBlank(message = "La fecha de la cita es obligatoria")
    private Date fecha_cita;
    @NotBlank(message = "Motivo es obligatorio")
    private String motivo;
    private String estado = "Pendiente";
    private String notas;


}

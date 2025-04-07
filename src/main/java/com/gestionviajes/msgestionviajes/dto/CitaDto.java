package com.gestionviajes.msgestionviajes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class CitaDto {
    @NotNull(message = "La fecha de la cita no puede ser nula")
    private LocalDateTime fechaCita;
   private Integer idCita;
    private String motivo;
    private String estado = "Pendiente";
    private String notas;
    private Integer idVeterinario;
    private Integer idMascota;


}

package com.gestionviajes.msgestionviajes.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter

public class CitaResponseDto {
    private Integer idCita;
    private LocalDateTime fechaCita;
    private String motivo;
    private String estado;
    private String notas;
    private Integer idMascota;
    private Integer idVeterinario;
}

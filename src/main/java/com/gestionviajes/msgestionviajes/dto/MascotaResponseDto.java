package com.gestionviajes.msgestionviajes.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MascotaResponseDto {
    private Integer id;
    private String nombre;
    private String especie;
    private String raza;
    private Date fecha_nacimiento;
    private String género;
    private String número_microchip;
}


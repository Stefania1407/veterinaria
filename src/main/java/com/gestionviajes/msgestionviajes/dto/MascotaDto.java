package com.gestionviajes.msgestionviajes.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class MascotaDto {
    @NotBlank(message = "Nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "Especie es obligatoria")
    private String especie;
    private String raza;
    private Date fecha_nacimiento;
    private String género;
    private String número_microchip;


}

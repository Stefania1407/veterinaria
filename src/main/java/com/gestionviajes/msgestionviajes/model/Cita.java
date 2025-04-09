package com.gestionviajes.msgestionviajes.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * DTO utilizado para crear o actualizar los datos de una mascota.
 * Incluye validaciones para campos obligatorios y permite enviar información básica del animal.
 */
@Getter
@Setter
public class MascotaDto {

    /**
     * ID del dueño de la mascota (relación con la entidad Dueño).
     */
    private Integer idDueño;

    /**
     * Nombre de la mascota. Campo obligatorio.
     */
    @NotBlank(message = "Nombre es obligatorio")
    private String nombre;

    /**
     * Especie de la mascota (ej. perro, gato). Campo obligatorio.
     */
    @NotBlank(message = "Especie es obligatoria")
    private String especie;

    /**
     * Raza de la mascota (opcional).
     */
    private String raza;

    /**
     * Fecha de nacimiento de la mascota (opcional).
     */
    private Date fecha_nacimiento;

    /**
     * Género de la mascota (opcional).
     */
    private String género;

    /**
     * Número de microchip, si la mascota tiene uno. Campo opcional.
     */
    private String número_microchip;
}

package com.gestionviajes.msgestionviajes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * DTO (Data Transfer Object) para representar una cita médica veterinaria.
 * Este objeto se usa para recibir datos del cliente al crear o actualizar una cita.
 */
@Getter
@Setter
public class CitaDto {

    /**
     * Fecha y hora programada para la cita.
     * No puede ser nula.
     */
    @NotNull(message = "La fecha de la cita no puede ser nula")
    private LocalDateTime fechaCita;

    /**
     * Identificador de la cita (opcional en creación).
     */
    private Integer idCita;

    /**
     * Motivo de la cita (consulta, chequeo, etc.).
     */
    private String motivo;

    /**
     * Estado de la cita. Por defecto es "Pendiente".
     */
    private String estado = "Pendiente";

    /**
     * Notas adicionales del veterinario o del sistema.
     */
    private String notas;

    /**
     * ID del veterinario que atenderá la cita.
     */
    private Integer idVeterinario;

    /**
     * ID de la mascota asociada a la cita.
     */
    private Integer idMascota;
}

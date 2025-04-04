package com.gestionviajes.msgestionviajes.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public class CitaDto {
    private Date fecha_cita;
    @NotBlank(message = "Motivo es obligatorio")
    private String motivo;
    private String estado = "Pendiente";
    private String notas;

    public Date getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(Date fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
}

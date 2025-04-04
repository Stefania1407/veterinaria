package com.gestionviajes.msgestionviajes.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public class MascotaDto {
    @NotBlank(message = "Nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "Especie es obligatoria")
    private String especie;
    private String raza;
    private Date fecha_nacimiento;
    private String género;
    private String número_microchip;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getGénero() {
        return género;
    }

    public void setGénero(String género) {
        this.género = género;
    }

    public String getNúmero_microchip() {
        return número_microchip;
    }

    public void setNúmero_microchip(String número_microchip) {
        this.número_microchip = número_microchip;
    }
}

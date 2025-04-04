package com.gestionviajes.msgestionviajes.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Mascota")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_mascota;

    @ManyToOne
    @JoinColumn(name = "id_dueño", nullable = false)
    private Duenio duenio;

    private String nombre;
    private String especie;
    private String raza;

    @Temporal(TemporalType.DATE)
    private Date fecha_nacimiento;

    private String género;
    private String número_microchip;

    @Temporal(TemporalType.DATE)
    private Date fecha_creación = new Date();

    public Integer getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(Integer id_mascota) {
        this.id_mascota = id_mascota;
    }

    public Duenio getDueño() {
        return duenio;
    }

    public void setDueño(Duenio duenio) {
        this.duenio = duenio;
    }

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

    public Date getFecha_creación() {
        return fecha_creación;
    }

    public void setFecha_creación(Date fecha_creación) {
        this.fecha_creación = fecha_creación;
    }
}

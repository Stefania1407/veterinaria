package com.gestionviajes.msgestionviajes.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Dueño")
public class Duenio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_dueño;

    private String nombre;
    private String apellidos;
    private String correo;
    private String teléfono;
    private String dirección;

    @Temporal(TemporalType.DATE)
    private Date fecha_creación = new Date();

    public Integer getId_dueño() {
        return id_dueño;
    }

    public void setId_dueño(Integer id_dueño) {
        this.id_dueño = id_dueño;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTeléfono() {
        return teléfono;
    }

    public void setTeléfono(String teléfono) {
        this.teléfono = teléfono;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public Date getFecha_creación() {
        return fecha_creación;
    }

    public void setFecha_creación(Date fecha_creación) {
        this.fecha_creación = fecha_creación;
    }
}

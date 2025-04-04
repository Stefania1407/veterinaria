package com.gestionviajes.msgestionviajes.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Veterinario")
public class Veterinario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_veterinario;

    private String nombre;
    private String apellidos;
    private String especialización;
    private String correo;
    private int telefono;

    @Temporal(TemporalType.DATE)
    private Date fecha_creación = new Date();

    public Integer getId_veterinario() {
        return id_veterinario;
    }

    public void setId_veterinario(Integer id_veterinario) {
        this.id_veterinario = id_veterinario;
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

    public String getEspecialización() {
        return especialización;
    }

    public void setEspecialización(String especialización) {
        this.especialización = especialización;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_creación() {
        return fecha_creación;
    }

    public void setFecha_creación(Date fecha_creación) {
        this.fecha_creación = fecha_creación;
    }
}

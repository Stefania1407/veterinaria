package com.gestionviajes.msgestionviajes.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class VeterinarioDto {
    @NotBlank(message = "Nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "Apellidos son obligatorios")
    private String apellidos;
    private String especialización;
    @NotBlank(message = "Correo es obligatorio")
    @Email(message = "Debe ser un correo válido")
    private String correo;
    private int telefono;

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
}

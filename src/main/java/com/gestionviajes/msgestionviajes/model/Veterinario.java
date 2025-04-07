package com.gestionviajes.msgestionviajes.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Veterinario")
@Getter
@Setter
public class Veterinario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_veterinario;

    private String nombre;
    private String apellidos;
    private String especialización;
    private String correo;
    private long telefono;

    @Temporal(TemporalType.DATE)
    private Date fecha_creación = new Date();


}

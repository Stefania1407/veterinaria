package com.gestionviajes.msgestionviajes.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Dueño")
@Getter
@Setter
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


}

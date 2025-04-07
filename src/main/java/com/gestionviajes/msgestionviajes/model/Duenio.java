package com.gestionviajes.msgestionviajes.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @OneToMany(mappedBy = "duenio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mascota> mascotas = new ArrayList<>();

    @Temporal(TemporalType.DATE)
    private Date fecha_creación = new Date();


}
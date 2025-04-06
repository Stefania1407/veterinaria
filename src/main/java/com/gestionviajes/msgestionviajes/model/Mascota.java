package com.gestionviajes.msgestionviajes.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Mascota")
@Getter
@Setter
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
}

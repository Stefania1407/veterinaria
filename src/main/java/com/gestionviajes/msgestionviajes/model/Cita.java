package com.gestionviajes.msgestionviajes.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name = "cita")
@Getter
@Setter
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cita;

    @ManyToOne
    @JoinColumn(name = "id_mascota", nullable = false)
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "id_veterinario")
    private Veterinario veterinario;
    private LocalDateTime fechaCita;

    private String motivo;
    private String estado = "Pendiente";
    private String notas;

    @Temporal(TemporalType.DATE)
    private Date fecha_creación = new Date();


}

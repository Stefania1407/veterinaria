package com.gestionviajes.msgestionviajes.repository;

import com.gestionviajes.msgestionviajes.model.Cita;
import com.gestionviajes.msgestionviajes.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {
    List<Cita> findByEstado(String estado);

    Optional<Cita> findByFechaCitaAndMascota(Date fecha_cita, Mascota mascota);
}

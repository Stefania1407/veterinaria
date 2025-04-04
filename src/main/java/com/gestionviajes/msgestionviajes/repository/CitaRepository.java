package com.gestionviajes.msgestionviajes.repository;

import com.gestionviajes.msgestionviajes.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitaRepository extends JpaRepository<Cita ,Integer> {
    List<Cita> findByEstado(String estado);
}

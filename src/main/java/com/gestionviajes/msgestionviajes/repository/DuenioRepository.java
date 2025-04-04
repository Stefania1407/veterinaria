package com.gestionviajes.msgestionviajes.repository;


import com.gestionviajes.msgestionviajes.model.Cita;
import com.gestionviajes.msgestionviajes.model.Duenio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DuenioRepository extends JpaRepository<Duenio, Integer> {
    Optional<Duenio> findByCorreoOrTeléfono(String correo, String teléfono);
}

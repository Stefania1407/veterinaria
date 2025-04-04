package com.gestionviajes.msgestionviajes.repository;


import com.gestionviajes.msgestionviajes.dto.HistorialMedicoDto;
import com.gestionviajes.msgestionviajes.model.Duenio;
import com.gestionviajes.msgestionviajes.model.HistorialMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HistorialMedicoRepository extends JpaRepository<HistorialMedico, Integer> {
    Optional<Duenio> findByCorreoOrTeléfono(String correo, String teléfono);
    Optional<HistorialMedicoDto> findAll(String keyword);
    Optional<HistorialMedico> findById(Integer id);
}

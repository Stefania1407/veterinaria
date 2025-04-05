package com.gestionviajes.msgestionviajes.repository;

import com.gestionviajes.msgestionviajes.model.HistorialMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HistorialMedicoRepository extends JpaRepository<HistorialMedico, Integer> {

    List<HistorialMedico> findByDiagnósticoContainingIgnoreCase(String keyword);
    List<HistorialMedico> findAll();
}

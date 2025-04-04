package com.gestionviajes.msgestionviajes.service;


import com.gestionviajes.msgestionviajes.model.Duenio;
import com.gestionviajes.msgestionviajes.model.HistorialMedico;
import com.gestionviajes.msgestionviajes.repository.HistorialMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialMedicoService {
    @Autowired
    private HistorialMedicoRepository historialMedicoRepository;

    public List<HistorialMedico> findAll() {

        return historialMedicoRepository.findAll();
    }

    public HistorialMedico saveHistorial(HistorialMedico historialMedico) {

        return historialMedicoRepository.save(historialMedico);
    }

    public Optional<HistorialMedico> findById(Integer id) {

        return historialMedicoRepository.findById(id);
    }

    public void eliminarHistorial(Integer id) {
        Optional<HistorialMedico> historialMedico = historialMedicoRepository.findById(id);

        if (historialMedico.isEmpty()) {
            throw new RuntimeException("HistorialMedico not found");
        }

        historialMedicoRepository.deleteById(id);
    }
}


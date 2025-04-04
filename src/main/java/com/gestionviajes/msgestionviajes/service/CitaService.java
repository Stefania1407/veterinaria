package com.gestionviajes.msgestionviajes.service;

import com.gestionviajes.msgestionviajes.model.Cita;
import com.gestionviajes.msgestionviajes.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    public List<Cita> findAll() {
        return citaRepository.findAll();
    }

    public Cita saveCita(Cita cita) {
        return citaRepository.save(cita);
    }

    public Optional<Cita> findById(Integer id) {
        return citaRepository.findById(id);
    }

    public void eliminarCita(Integer id) {
        citaRepository.deleteById(id);
    }
}

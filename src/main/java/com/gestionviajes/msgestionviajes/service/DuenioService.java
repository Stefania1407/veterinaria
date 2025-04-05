package com.gestionviajes.msgestionviajes.service;

import com.gestionviajes.msgestionviajes.dto.DuenioDto;
import com.gestionviajes.msgestionviajes.model.Duenio;
import com.gestionviajes.msgestionviajes.repository.DuenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DuenioService {
    @Autowired
    private DuenioRepository duenioRepository;

    public List<Duenio> findAll() {
        return duenioRepository.findAll();
    }

    public Optional<Duenio> findById(Integer id) {
        return duenioRepository.findById(id);
    }

    public Optional<Duenio> findByCorreo(String correo) {
        return duenioRepository.findByCorreo(correo);
    }

    public Duenio save(DuenioDto dto) {
        // Verificamos si ya existe un dueño con ese correo
        if (duenioRepository.findByCorreo(dto.getCorreo()).isPresent()) {
            throw new RuntimeException("Ya existe un dueño con ese correo.");
        }

        Duenio duenio = new Duenio();
        duenio.setNombre(dto.getNombre());
        duenio.setApellidos(dto.getApellidos());
        duenio.setCorreo(dto.getCorreo());
        duenio.setTeléfono(dto.getTeléfono());
        duenio.setDirección(dto.getDirección());
        return duenioRepository.save(duenio);
    }

    public boolean update(Integer id, DuenioDto dto) {
        Optional<Duenio> optional = duenioRepository.findById(id);
        if (optional.isPresent()) {
            Duenio duenio = optional.get();
            duenio.setNombre(dto.getNombre());
            duenio.setApellidos(dto.getApellidos());
            duenio.setCorreo(dto.getCorreo());
            duenio.setTeléfono(dto.getTeléfono());
            duenio.setDirección(dto.getDirección());
            duenioRepository.save(duenio);
            return true;
        }
        return false;
    }

    public boolean delete(Integer id) {
        if (duenioRepository.existsById(id)) {
            duenioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

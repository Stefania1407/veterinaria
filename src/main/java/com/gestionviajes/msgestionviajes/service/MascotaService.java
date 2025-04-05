package com.gestionviajes.msgestionviajes.service;

import com.gestionviajes.msgestionviajes.dto.MascotaDto;
import com.gestionviajes.msgestionviajes.model.Mascota;
import com.gestionviajes.msgestionviajes.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    public List<Mascota> findAllMascotas() {
        return mascotaRepository.findAll();
    }

    public Optional<Mascota> findMascotaById(Integer id) {
        return mascotaRepository.findById(id);
    }

    public Mascota createMascota(MascotaDto dto) {
        Mascota mascota = new Mascota();
        mascota.setNombre(dto.getNombre());
        mascota.setEspecie(dto.getEspecie());
        mascota.setRaza(dto.getRaza());
        mascota.setFecha_nacimiento(dto.getFecha_nacimiento());
        mascota.setGénero(dto.getGénero());
        mascota.setNúmero_microchip(dto.getNúmero_microchip());
        return mascotaRepository.save(mascota);
    }

    public boolean updateMascota(Integer id, MascotaDto dto) {
        Optional<Mascota> mascotaOptional = mascotaRepository.findById(id);
        if (mascotaOptional.isPresent()) {
            Mascota mascota = mascotaOptional.get();
            mascota.setNombre(dto.getNombre());
            mascota.setEspecie(dto.getEspecie());
            mascota.setRaza(dto.getRaza());
            mascota.setFecha_nacimiento(dto.getFecha_nacimiento());
            mascota.setGénero(dto.getGénero());
            mascota.setNúmero_microchip(dto.getNúmero_microchip());
            mascotaRepository.save(mascota);
            return true;
        }
        return false;
    }

    public boolean deleteMascota(Integer id) {
        if (mascotaRepository.existsById(id)) {
            mascotaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

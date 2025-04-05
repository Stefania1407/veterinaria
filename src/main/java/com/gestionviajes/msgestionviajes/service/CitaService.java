package com.gestionviajes.msgestionviajes.service;

import com.gestionviajes.msgestionviajes.dto.CitaDto;
import com.gestionviajes.msgestionviajes.exception.SaveCitaNotFoundException;
import com.gestionviajes.msgestionviajes.model.Cita;
import com.gestionviajes.msgestionviajes.model.Mascota;
import com.gestionviajes.msgestionviajes.repository.CitaRepository;
import com.gestionviajes.msgestionviajes.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;
    @Autowired
    private MascotaRepository mascotaRepository;

    public List<Cita> findAllCitas() {
        return citaRepository.findAll();
    }

    public Optional<Cita> findCitaById(Integer id) {
        return citaRepository.findById(id);
    }

    public Cita saveCita(CitaDto citaDto, Integer idMascota) {
        Mascota mascota = mascotaRepository.findById(idMascota)
                .orElseThrow(() -> new SaveCitaNotFoundException("Mascota no encontrada" + idMascota));

        Optional<Cita> citaExistente = citaRepository.findByFechaCitaAndMascota(
                citaDto.getFechaCita(), mascota
        );

        if (citaExistente.isPresent()) {
            throw new SaveCitaNotFoundException("Ya existe una cita para esta fecha y mascota");
        }

        Cita cita = new Cita();
        cita.setFechaCita(citaDto.getFechaCita());
        cita.setMotivo(citaDto.getMotivo());
        cita.setEstado(citaDto.getEstado());
        cita.setNotas(citaDto.getNotas());
        cita.setMascota(mascota);

        return citaRepository.save(cita);
    }

    public boolean updateCita(Integer id, CitaDto citaDto) {
        Optional<Cita> optionalCita = citaRepository.findById(id);
        if (optionalCita.isPresent()) {
            Cita citaToUpdate = optionalCita.get();
            citaToUpdate.setFechaCita(citaDto.getFechaCita());
            citaToUpdate.setMotivo(citaDto.getMotivo());
            citaToUpdate.setEstado(citaDto.getEstado());
            citaToUpdate.setNotas(citaDto.getNotas());
            citaRepository.save(citaToUpdate);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteCita(Integer id) {
        if (citaRepository.existsById(id)) {
            citaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

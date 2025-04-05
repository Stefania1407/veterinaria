package com.gestionviajes.msgestionviajes.service;

import com.gestionviajes.msgestionviajes.dto.HistorialMedicoDto;
import com.gestionviajes.msgestionviajes.model.HistorialMedico;
import com.gestionviajes.msgestionviajes.model.Mascota;
import com.gestionviajes.msgestionviajes.repository.HistorialMedicoRepository;
import com.gestionviajes.msgestionviajes.repository.MascotaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HistorialMedicoService {

    private  HistorialMedicoRepository historialMedicoRepository;
    private  MascotaRepository mascotaRepository;

    @Transactional
    public HistorialMedico save(HistorialMedicoDto dto, Integer idMascota) {
        // Validamos que la mascota exista
        Optional<Mascota> mascotaOpt = mascotaRepository.findById(idMascota);
        if (mascotaOpt.isEmpty()) {
            throw new RuntimeException("No se encontró una mascota con el ID proporcionado: " + idMascota);
        }

        Mascota mascota = mascotaOpt.get();

        // Creamos y guardamos el historial médico
        HistorialMedico historial = new HistorialMedico();
        historial.setDiagnóstico(dto.getDiagnóstico());
        historial.setTratamiento(dto.getTratamiento());
        historial.setMedicación(dto.getMedicación());
        historial.setNotas(dto.getNotas());
        historial.setMascota(mascota);

        return historialMedicoRepository.save(historial);
    }

    public Optional<HistorialMedico> findById(Integer id) {
        return historialMedicoRepository.findById(id);
    }

    public boolean deleteById(Integer id) {
        if (historialMedicoRepository.existsById(id)) {
            historialMedicoRepository.deleteById(id);
        } else {
            throw new RuntimeException("No se encontró un historial médico con el ID proporcionado: " + id);
        }
        return false;
    }

    public List<HistorialMedico> findAll() {
        return historialMedicoRepository.findAll();
    }

    public HistorialMedico update(Integer id, HistorialMedicoDto dto) {
        Optional<HistorialMedico> optional = historialMedicoRepository.findById(id);
        if (optional.isPresent()) {
            HistorialMedico historial = optional.get();
            historial.setDiagnóstico(dto.getDiagnóstico());
            historial.setTratamiento(dto.getTratamiento());
            historial.setMedicación(dto.getMedicación());
            historial.setNotas(dto.getNotas());
            return historialMedicoRepository.save(historial);
        }
        throw new RuntimeException("No se encontró un historial médico con el ID proporcionado: " + id);
    }
}

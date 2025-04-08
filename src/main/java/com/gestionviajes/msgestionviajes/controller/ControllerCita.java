package com.gestionviajes.msgestionviajes.controller;

import com.gestionviajes.msgestionviajes.dto.CitaDto;
import com.gestionviajes.msgestionviajes.dto.CitaResponseDto;
import com.gestionviajes.msgestionviajes.model.Cita;
import com.gestionviajes.msgestionviajes.service.CitaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/citas")
@RequiredArgsConstructor
public class ControllerCita {

    @Autowired
    private CitaService citaService;

    @GetMapping
    public ResponseEntity<List<CitaResponseDto>> getAllCitas() {
        return ResponseEntity.ok(citaService.getAllCitaDtos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaResponseDto> getCitaById(@PathVariable Integer id) {
        return citaService.findCitaById(id)
                .map(citaService::mapToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    // Crear cita
    @PostMapping("/mascota/{idMascota}")
    public ResponseEntity<?> createCita(@PathVariable Integer idMascota, @Valid @RequestBody CitaDto citaDto) {
        try {
            Cita cita = citaService.saveCita(citaDto, idMascota);
            CitaResponseDto response = citaService.mapToDto(cita); // llamas al mapper
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    // Actualizar cita
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCita(@PathVariable Integer id, @Valid @RequestBody CitaDto citaDto) {
        try {
            boolean updated = citaService.updateCita(id, citaDto);
            return updated ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Eliminar cita
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCita(@PathVariable Integer id) {
        boolean deleted = citaService.deleteCita(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}

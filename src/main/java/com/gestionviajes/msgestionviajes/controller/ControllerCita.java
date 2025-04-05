package com.gestionviajes.msgestionviajes.controller;

import com.gestionviajes.msgestionviajes.dto.CitaDto;
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
    private  CitaService citaService;

    @GetMapping
    public ResponseEntity<List<Cita>> getAllCitas() {
        return ResponseEntity.ok(citaService.findAllCitas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> getCitaById(@PathVariable Integer id) {
        return citaService.findCitaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/mascota/{idMascota}")
    public ResponseEntity<?> createCita(@PathVariable Integer idMascota, @Valid @RequestBody CitaDto citaDto) {
        try {
            Cita cita = citaService.saveCita(citaDto, idMascota);
            return ResponseEntity.ok(cita);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCita(@PathVariable Integer id, @Valid @RequestBody CitaDto citaDto) {
        try {
            boolean updated = citaService.updateCita(id, citaDto);
            return updated ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCita(@PathVariable Integer id) {
        boolean deleted = citaService.deleteCita(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}

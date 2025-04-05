package com.gestionviajes.msgestionviajes.controller;

import com.gestionviajes.msgestionviajes.dto.HistorialMedicoDto;
import com.gestionviajes.msgestionviajes.model.HistorialMedico;
import com.gestionviajes.msgestionviajes.service.HistorialMedicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historiales")
@RequiredArgsConstructor
public class ControllerHistorialMedico {

    @Autowired
    private  HistorialMedicoService historialMedicoService;

    @GetMapping
    public ResponseEntity<List<HistorialMedico>> getAll() {
        return ResponseEntity.ok(historialMedicoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialMedico> getById(@PathVariable Integer id) {
        return historialMedicoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HistorialMedico> create(@Valid @RequestBody HistorialMedicoDto dto, @RequestBody Integer idMascota) {
        return ResponseEntity.ok(historialMedicoService.save(dto, idMascota));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody HistorialMedicoDto dto) {
       return ResponseEntity.ok(historialMedicoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        boolean deleted = historialMedicoService.deleteById(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}


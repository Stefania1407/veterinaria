package com.gestionviajes.msgestionviajes.controller;

import com.gestionviajes.msgestionviajes.dto.DuenioDto;
import com.gestionviajes.msgestionviajes.model.Duenio;
import com.gestionviajes.msgestionviajes.service.DuenioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/duenios")
public class ControllerDuenio {

    @Autowired
    private DuenioService duenioService;

    @GetMapping
    public ResponseEntity<List<Duenio>> getAll() {
        return ResponseEntity.ok(duenioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Duenio> getById(@PathVariable Integer id) {
        return duenioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody DuenioDto dto) {
        try {
            Duenio nuevo = duenioService.save(dto);
            return ResponseEntity.ok(nuevo);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody DuenioDto dto) {
        boolean updated = duenioService.update(id, dto);
        return updated ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        boolean deleted = duenioService.delete(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}

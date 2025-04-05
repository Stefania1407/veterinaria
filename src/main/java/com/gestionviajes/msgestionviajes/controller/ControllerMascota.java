package com.gestionviajes.msgestionviajes.controller;

import com.gestionviajes.msgestionviajes.dto.MascotaDto;
import com.gestionviajes.msgestionviajes.model.Mascota;
import com.gestionviajes.msgestionviajes.service.MascotaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/mascotas")
@RequiredArgsConstructor
public class ControllerMascota {

    @Autowired
    private MascotaService mascotaService;

    @GetMapping
    public ResponseEntity<List<Mascota>> getAllMascotas() {
        return ResponseEntity.ok(mascotaService.findAllMascotas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mascota> getMascotaById(@PathVariable Integer id) {
        return mascotaService.findMascotaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Mascota> createMascota(@Valid @RequestBody MascotaDto dto) {
        return ResponseEntity.ok(mascotaService.createMascota(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMascota(@PathVariable Integer id, @Valid @RequestBody MascotaDto dto) {
        boolean updated = mascotaService.updateMascota(id, dto);
        return updated ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMascota(@PathVariable Integer id) {
        boolean deleted = mascotaService.deleteMascota(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}


package com.gestionviajes.msgestionviajes.controller;

import com.gestionviajes.msgestionviajes.dto.VeterinarioDto;
import com.gestionviajes.msgestionviajes.model.Veterinario;
import com.gestionviajes.msgestionviajes.service.VeterinarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gestionar veterinarios.
 * Proporciona endpoints para listar, obtener, crear y eliminar veterinarios.
 */
@RestController
@RequestMapping("api/veterinarios")
@RequiredArgsConstructor
public class ControllerVeterinario {

    // Inyección del servicio de veterinarios
    @Autowired
    private VeterinarioService veterinarioService;

    /**
     * Obtiene todos los veterinarios registrados.
     * @return Lista de objetos Veterinario.
     */
    @GetMapping
    public ResponseEntity<List<Veterinario>> getAllVeterinarios() {
        List<Veterinario> veterinarios = veterinarioService.findAll();
        return ResponseEntity.ok(veterinarios);
    }

    /**
     * Busca un veterinario por su ID.
     * @param id ID del veterinario.
     * @return Objeto Veterinario si se encuentra, 404 si no.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Veterinario> getVeterinarioById(@PathVariable Integer id) {
        Optional<Veterinario> veterinario = veterinarioService.findById(id);
        return veterinario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Crea un nuevo veterinario.
     * @param veterinarioDto Datos del nuevo veterinario.
     * @return Objeto Veterinario creado o mensaje de error si los datos son inválidos.
     */
    @PostMapping
    public ResponseEntity<?> createVeterinario(@Valid @RequestBody VeterinarioDto veterinarioDto) {
        try {
            Veterinario nuevoVeterinario = veterinarioService.saveVeterinario(veterinarioDto);
            return ResponseEntity.ok(nuevoVeterinario);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * Elimina un veterinario por su ID.
     * @param id ID del veterinario a eliminar.
     * @return 200 OK si se elimina, 404 si no se encuentra.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeterinario(@PathVariable Integer id) {
        Optional<Veterinario> veterinario = veterinarioService.findById(id);
        if (veterinario.isPresent()) {
            veterinarioService.deleteVeterinario(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

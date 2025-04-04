package com.gestionviajes.msgestionviajes.repository;

import com.gestionviajes.msgestionviajes.model.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VeterinarioRepository extends JpaRepository<Veterinario , Integer> {
    Optional<Veterinario> findByCorreo(String correo);
}

package com.gestionviajes.msgestionviajes.repository;


import com.gestionviajes.msgestionviajes.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MascotaRepository extends JpaRepository<Mascota , Integer> {
    List<Mascota> findByEspecie(String especie);
}

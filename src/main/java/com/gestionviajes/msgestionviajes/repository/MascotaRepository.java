package com.gestionviajes.msgestionviajes.repository;


import com.gestionviajes.msgestionviajes.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota , Integer> {
    List<Mascota> findByEspecie(String especie);
}

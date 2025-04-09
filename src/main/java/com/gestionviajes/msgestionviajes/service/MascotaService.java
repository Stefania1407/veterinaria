package com.gestionviajes.msgestionviajes.service;

import com.gestionviajes.msgestionviajes.dto.MascotaDto;
import com.gestionviajes.msgestionviajes.dto.MascotaResponseDto;
import com.gestionviajes.msgestionviajes.model.Duenio;
import com.gestionviajes.msgestionviajes.model.Mascota;
import com.gestionviajes.msgestionviajes.repository.DuenioRepository;
import com.gestionviajes.msgestionviajes.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio encargado de manejar la lógica de negocio relacionada con las mascotas.
 * Incluye operaciones para crear, actualizar, eliminar y consultar mascotas.
 */
@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private DuenioRepository duenioRepository;

    /**
     * Obtiene todas las mascotas registradas en el sistema.
     *
     * @return Lista de mascotas.
     */
    public List<Mascota> findAllMascotas() {
        return mascotaRepository.findAll();
    }

    /**
     * Busca una mascota por su ID.
     *
     * @param id Identificador de la mascota.
     * @return Un {@link Optional} que contiene la mascota si existe.
     */
    public Optional<Mascota> findMascotaById(Integer id) {
        return mascotaRepository.findById(id);
    }

    /**
     * Obtiene todas las mascotas en formato DTO.
     *
     * @return Lista de {@link MascotaResponseDto}.
     */
    public List<MascotaResponseDto> getAllMascotaDtos() {
        return mascotaRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    /**
     * Crea una nueva mascota en el sistema.
     *
     * @param dto Datos de la mascota.
     * @return La mascota creada.
     * @throws RuntimeException Si no se encuentra el dueño con el ID proporcionado.
     */
    public Mascota createMascota(MascotaDto dto) {
        Optional<Duenio> duenioOptional = duenioRepository.findById(dto.getIdDueño());
        if (duenioOptional.isEmpty()) {
            throw new RuntimeException("Dueño no encontrado con id: " + dto.getIdDueño());
        }

        Mascota mascota = new Mascota();
        mascota.setDuenio(duenioOptional.get());
        mascota.setNombre(dto.getNombre());
        mascota.setEspecie(dto.getEspecie());
        mascota.setRaza(dto.getRaza());
        mascota.setFecha_nacimiento(dto.getFecha_nacimiento());
        mascota.setGénero(dto.getGénero());
        mascota.setNúmero_microchip(dto.getNúmero_microchip());

        return mascotaRepository.save(mascota);
    }

    /**
     * Actualiza los datos de una mascota existente.
     *
     * @param id  ID de la mascota a actualizar.
     * @param dto Datos nuevos de la mascota.
     * @return true si la actualización fue exitosa, false si la mascota no existe.
     */
    public boolean updateMascota(Integer id, MascotaDto dto) {
        Optional<Mascota> mascotaOptional = mascotaRepository.findById(id);
        if (mascotaOptional.isPresent()) {
            Mascota mascota = mascotaOptional.get();
            mascota.setNombre(dto.getNombre());
            mascota.setEspecie(dto.getEspecie());
            mascota.setRaza(dto.getRaza());
            mascota.setFecha_nacimiento(dto.getFecha_nacimiento());
            mascota.setGénero(dto.getGénero());
            mascota.setNúmero_microchip(dto.getNúmero_microchip());
            mascotaRepository.save(mascota);
            return true;
        }
        return false;
    }

    /**
     * Elimina una mascota por su ID.
     *
     * @param id ID de la mascota a eliminar.
     * @return true si se eliminó con éxito, false si no existe.
     */
    public boolean deleteMascota(Integer id) {
        if (mascotaRepository.existsById(id)) {
            mascotaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Convierte un objeto {@link Mascota} a su representación {@link MascotaResponseDto}.
     *
     * @param mascota Objeto mascota a convertir.
     * @return Objeto convertido en formato DTO.
     */
    public MascotaResponseDto convertToDto(Mascota mascota) {
        MascotaResponseDto dto = new MascotaResponseDto();
        dto.setId(mascota.getId_mascota());
        dto.setNombre(mascota.getNombre());
        dto.setEspecie(mascota.getEspecie());
        dto.setRaza(mascota.getRaza());
        dto.setFecha_nacimiento(mascota.getFecha_nacimiento());
        dto.setGénero(mascota.getGénero());
        dto.setNúmero_microchip(mascota.getNúmero_microchip());
        return dto;
    }

}

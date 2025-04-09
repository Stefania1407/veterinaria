package com.gestionviajes.msgestionviajes.service;

import com.gestionviajes.msgestionviajes.dto.VeterinarioDto;
import com.gestionviajes.msgestionviajes.model.Veterinario;
import com.gestionviajes.msgestionviajes.repository.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio encargado de manejar la lógica relacionada con los veterinarios.
 */
@Service
public class VeterinarioService {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    /**
     * Obtiene todos los veterinarios registrados en el sistema.
     *
     * @return Lista de objetos {@link Veterinario}.
     */
    public List<Veterinario> findAll() {
        return veterinarioRepository.findAll();
    }

    /**
     * Busca un veterinario por su ID.
     *
     * @param id ID del veterinario.
     * @return Un {@link Optional} con el veterinario si se encuentra.
     */
    public Optional<Veterinario> findById(Integer id) {
        return veterinarioRepository.findById(id);
    }

    /**
     * Busca un veterinario por su correo electrónico.
     *
     * @param correo Correo del veterinario.
     * @return Un {@link Optional} con el veterinario si se encuentra.
     */
    public Optional<Veterinario> findByCorreo(String correo) {
        return veterinarioRepository.findByCorreo(correo);
    }

    /**
     * Guarda un nuevo veterinario en la base de datos.
     *
     * @param veterinarioDto Objeto con los datos del veterinario.
     * @return El veterinario creado.
     * @throws IllegalArgumentException Si ya existe un veterinario con el mismo correo.
     */
    public Veterinario saveVeterinario(VeterinarioDto veterinarioDto) {
        if (veterinarioRepository.findByCorreo(veterinarioDto.getCorreo()).isPresent()) {
            throw new IllegalArgumentException("Ya existe un veterinario con ese correo.");
        }

        Veterinario veterinario = new Veterinario();
        veterinario.setNombre(veterinarioDto.getNombre());
        veterinario.setApellidos(veterinarioDto.getApellidos());
        veterinario.setEspecialización(veterinarioDto.getEspecialización());
        veterinario.setCorreo(veterinarioDto.getCorreo());
        veterinario.setTelefono(veterinarioDto.getTelefono());

        return veterinarioRepository.save(veterinario);
    }

    /**
     * Actualiza los datos de un veterinario existente por su ID.
     *
     * @param id  ID del veterinario.
     * @param dto Objeto con los nuevos datos.
     * @return true si el veterinario fue actualizado; false si no fue encontrado.
     */
    public boolean updateVeterinario(Integer id, VeterinarioDto dto) {
        Optional<Veterinario> optionalVeterinario = veterinarioRepository.findById(id);
        if (optionalVeterinario.isPresent()) {
            Veterinario vetToUpdate = optionalVeterinario.get();

            // Validación opcional si deseas asegurar unicidad del correo en la actualización
            Optional<Veterinario> existingByCorreo = veterinarioRepository.findByCorreo(dto.getCorreo());
            if (existingByCorreo.isPresent() && !existingByCorreo.get().getId_veterinario().equals(id)) {
                throw new IllegalArgumentException("Ya existe otro veterinario con ese correo.");
            }

            vetToUpdate.setNombre(dto.getNombre());
            vetToUpdate.setApellidos(dto.getApellidos());
            vetToUpdate.setCorreo(dto.getCorreo());
            vetToUpdate.setTelefono(dto.getTelefono());

            veterinarioRepository.save(vetToUpdate);
            return true;
        }
        return false;
    }

    /**
     * Elimina un veterinario por su ID.
     *
     * @param id ID del veterinario.
     * @return true si fue eliminado correctamente; false si no existe.
     */
    public boolean deleteVeterinario(Integer id) {
        if (veterinarioRepository.existsById(id)) {
            veterinarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Actualiza un veterinario directamente mediante un objeto completo.
     *
     * @param veterinario Veterinario a actualizar.
     * @return Veterinario actualizado.
     */
    public Veterinario updateVeterinario(Veterinario veterinario) {
        return veterinarioRepository.save(veterinario);
    }
}

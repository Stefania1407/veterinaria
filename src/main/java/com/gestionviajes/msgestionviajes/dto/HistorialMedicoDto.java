package com.gestionviajes.msgestionviajes.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class HistorialMedicoDto {
    @NotBlank(message = "Diagnóstico es obligatorio")
    private String diagnóstico;
    @NotBlank(message = "Tratamiento es obligatorio")
    private String tratamiento;
    private String medicación;
    private String notas;

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getMedicación() {
        return medicación;
    }

    public void setMedicación(String medicación) {
        this.medicación = medicación;
    }

    public @NotBlank(message = "Tratamiento es obligatorio") String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(@NotBlank(message = "Tratamiento es obligatorio") String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public @NotBlank(message = "Diagnóstico es obligatorio") String getDiagnóstico() {
        return diagnóstico;
    }

    public void setDiagnóstico(@NotBlank(message = "Diagnóstico es obligatorio") String diagnóstico) {
        this.diagnóstico = diagnóstico;
    }
}

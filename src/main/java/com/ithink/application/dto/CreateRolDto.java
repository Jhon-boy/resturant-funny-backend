package com.ithink.application.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateRolDto {
    public Long idRol;
    @NotBlank(message = "El codigo de puede estar vacío.")
    public String codigo;
    @NotBlank(message = "El observacion de puede estar vacío.")
    public String observacion;
    @NotBlank(message = "El estado de puede estar vacío.")
    public String estado;
    @NotBlank(message = "El usuarioIngreso de puede estar vacío.")
    public String usuarioIngreso;
    @NotBlank(message = "El nombre de puede estar vacío.")
    public String nombre;
}

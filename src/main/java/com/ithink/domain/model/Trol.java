package com.ithink.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trol {
    private Long idRol;
    private String codigo;
    private String nombre;
    private String observacion;
    private String estado;
    private String usuarioIngreso;
    private String usuarioModificacion;
    private Date fCreacion;
    private Date fActualizacion;
}

package com.ithink.infra.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * JPA Entity for user roles
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "public", name = "TROL")
public class TrolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDROL")
    public Long idRol;
    @Column(name = "CODIGO",length = 3, nullable = false)
    public String codigo;
    @Column(name = "NOMBRE", length = 50, nullable = false)
    public String nombre;
    @Column(name = "OBSERVACION", length = 200)
    public String observacion;
    @Column(name = "ESTADO", length = 3)
    public String estado;
    @Column(name = "USUARIOINGRESO")
    public String usuarioIngreso;
    @Column(name = "USERMODIFICACION")
    public String usuarioModificacion;
    @Column(name = "FCREACION",  nullable = false)
    public Date fCreacion;
    @Column(name = "FMODIFICACION")
    public Date fActualizacion;
}

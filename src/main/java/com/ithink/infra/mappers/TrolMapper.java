package com.ithink.infra.mappers;

import com.ithink.domain.model.Trol;
import com.ithink.infra.entity.TrolEntity;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Mapper to convert between domain entities and JPA entities
 */
@Component
public class TrolMapper {

    /**
     * Converts from JPA entity to domain model
     */
    public Trol toDomain(TrolEntity entity) {
        if (entity == null) {
            return null;
        }
        return Trol.builder()
                .idRol(entity.idRol)
                .codigo(entity.codigo)
                .nombre(entity.nombre)
                .observacion(entity.observacion)
                .estado(entity.estado)
                .usuarioIngreso(entity.usuarioIngreso)
                .usuarioModificacion(entity.usuarioModificacion)
                .fCreacion(entity.fCreacion)
                .fActualizacion(entity.fActualizacion)
                .build();
    }

    /**
     * Converts from domain model to JPA entity
     */
    public TrolEntity toEntity(Trol domain) {
        if (domain == null) {
            return null;
        }
        TrolEntity entity = new TrolEntity();
        entity.idRol = domain.getIdRol();
        entity.codigo = domain.getCodigo();
        entity.nombre = domain.getNombre();
        entity.observacion = domain.getObservacion();
        entity.estado = domain.getEstado();
        entity.usuarioIngreso = domain.getUsuarioIngreso();
        entity.usuarioModificacion = domain.getUsuarioModificacion();
        entity.fCreacion = domain.getFCreacion() != null ? domain.getFCreacion() : new Date();
        entity.fActualizacion = domain.getFActualizacion();
        return entity;
    }
}


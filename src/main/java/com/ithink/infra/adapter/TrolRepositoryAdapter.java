package com.ithink.infra.adapter;

import com.ithink.application.dto.CreateRolDto;
import com.ithink.application.dto.ResponseGraphQl;
import com.ithink.domain.model.Trol;
import com.ithink.domain.port.in.TrolPort;
import com.ithink.domain.port.out.TrolRepositoryPort;
import com.ithink.infra.entity.TrolEntity;
import com.ithink.infra.mappers.TrolMapper;
import com.ithink.infra.repository.TrolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TrolRepositoryAdapter implements TrolPort, TrolRepositoryPort {

    private final TrolRepository repository;
    private final TrolMapper mapper;

    @Override
    public ResponseGraphQl crearRol(CreateRolDto createRolDto) {
        try {
            if (createRolDto.getCodigo() == null || createRolDto.getCodigo().trim().isEmpty()) {
                return ResponseGraphQl.BadResponse("El código del rol es requerido");
            }
            if (createRolDto.getNombre() == null || createRolDto.getNombre().trim().isEmpty()) {
                return ResponseGraphQl.BadResponse("El nombre del rol es requerido");
            }
            if (createRolDto.getCodigo().length() > 3) {
                return ResponseGraphQl.BadResponse("El código no puede tener más de 3 caracteres");
            }
            if (createRolDto.getNombre().length() > 50) {
                return ResponseGraphQl.BadResponse("El nombre no puede tener más de 50 caracteres");
            }

            Optional<Trol> existing = findByCodigo(createRolDto.getCodigo());
            if (existing.isPresent()) {
                return ResponseGraphQl.BadResponse("Ya existe un rol con el código: " + createRolDto.getCodigo());
            }

            Trol trol = Trol.builder()
                    .codigo(createRolDto.getCodigo())
                    .nombre(createRolDto.getNombre())
                    .observacion(createRolDto.getObservacion())
                    .estado(createRolDto.getEstado() != null ? createRolDto.getEstado() : "ACT")
                    .usuarioIngreso(createRolDto.getUsuarioIngreso())
                    .fCreacion(new Date())
                    .build();

            Trol savedTrol = save(trol);
            return ResponseGraphQl.OkResponse(savedTrol);

        } catch (Exception e) {
            return ResponseGraphQl.BadResponse("Error al crear el rol: " + e.getMessage());
        }
    }

    @Override
    public ResponseGraphQl obtenerRolPorId(Long idRol) {
        try {
            if (idRol == null || idRol <= 0) {
                return ResponseGraphQl.BadResponse("El ID del rol debe ser un valor válido");
            }

            Optional<Trol> trol = findById(idRol);
            if (trol.isEmpty()) {
                return ResponseGraphQl.BadResponse("No se encontró un rol con el ID: " + idRol);
            }

            return ResponseGraphQl.OkResponse(trol.get());

        } catch (Exception e) {
            return ResponseGraphQl.BadResponse("Error al obtener el rol: " + e.getMessage());
        }
    }

    @Override
    public ResponseGraphQl obtenerTodosLosRoles() {
        try {
            List<TrolEntity> entities = repository.findAll();
            List<Trol> roles = entities.stream()
                    .map(mapper::toDomain)
                    .collect(Collectors.toList());

            return ResponseGraphQl.OkResponse(roles);

        } catch (Exception e) {
            return ResponseGraphQl.BadResponse("Error al obtener los roles: " + e.getMessage());
        }
    }

    @Override
    public Trol save(Trol trol) {
        TrolEntity entity = mapper.toEntity(trol);
        TrolEntity savedEntity = repository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Trol> findById(Long idRol) {
        return repository.findById(idRol)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<Trol> findByCodigo(String codigo) {
        return repository.findByCodigo(codigo)
                .map(mapper::toDomain);
    }
}

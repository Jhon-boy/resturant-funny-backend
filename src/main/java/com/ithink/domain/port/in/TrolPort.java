package com.ithink.domain.port.in;

import com.ithink.application.dto.CreateRolDto;
import com.ithink.application.dto.ResponseGraphQl;

public interface TrolPort {
    ResponseGraphQl crearRol(CreateRolDto createRolDto);
    ResponseGraphQl obtenerRolPorId(Long idRol);
    ResponseGraphQl obtenerTodosLosRoles();
}


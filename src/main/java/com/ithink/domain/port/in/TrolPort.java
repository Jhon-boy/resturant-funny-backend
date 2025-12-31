package com.ithink.domain.port.in;

import com.ithink.application.dto.ResponseGraphQl;

public interface TrolPort {
    ResponseGraphQl obtenerRolPorId(Long idRol);
    ResponseGraphQl obtenerTodosLosRoles();
}


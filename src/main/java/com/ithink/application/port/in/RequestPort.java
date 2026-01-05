package com.ithink.application.port.in;

import jakarta.servlet.http.HttpServletRequest;

/*
* Interfaz obtener la direccion IP de una peticion
* JB
* */
public interface RequestPort {
    /**
     * Obtiene la direccion Ip de la peticion
     *
     * @param httpServletRequest
     */
    String getClientIp(HttpServletRequest httpServletRequest);
    /**
     * Obtiene la informacion del dispositivo
     *
     * @param httpServletRequest
     */
    String getUserAgent(HttpServletRequest httpServletRequest);
}

package com.ithink.domain.config.trazability;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;

/**
 * Trazabilidad de la aplicacion para seguimiento de LOGS mediante un identificador unico
 * JB
 * */
public class UuidTrazabaility implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UUID uuid = UUID.randomUUID();
        ThreadContext.put("uuid", uuid.toString());
        return true;
    }

}

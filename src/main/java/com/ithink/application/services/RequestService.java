package com.ithink.application.services;

import com.ithink.application.port.in.RequestPort;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

/**
 * Clase que proporciona el servicio para la obtencion de direcciones IP de una peticion
 * JB
 * */
@Service
public class RequestService implements RequestPort {
    @Override
    public String getClientIp(HttpServletRequest httpServletRequest) {
        String ipAddress = null;
        try {
            if(httpServletRequest!=null) {
                ipAddress = httpServletRequest.getHeader("X-FORWARDED-FOR");
                if (ipAddress == null) {
                    ipAddress = httpServletRequest.getRemoteAddr();
                }else {
                    String arreglo [] = ipAddress.split(", ");
                    ipAddress = arreglo[0];
                }
            }
            return ipAddress;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ipAddress;
    }

    @Override
    public String getUserAgent(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getHeader("user-agent");
    }
}

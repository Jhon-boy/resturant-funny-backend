package com.ithink.domain.config;


import com.ithink.application.services.LoggerService;
import com.ithink.application.services.RequestService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Interceptor para capturar y registrar información de todas las peticiones HTTP
 * Registra IP del cliente, User-Agent, método HTTP, URI y parámetros
 * JB
 */
@Component
public class HttpRequestInterceptor implements HandlerInterceptor {

    @Autowired
    @Lazy
    private RequestService requestService;

    private final LoggerService logger = new LoggerService();

    /**
     * Importante: Metodo que recepta peticiones HTTP mostrando la informacion base de CADA peticion, NO INCLUIR EN LOGGERs que hagan lo mismo en cada CONTROLADOR
     * JB
     * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.setLogger(HttpRequestInterceptor.class);

        String clientIp = requestService.getClientIp(request);
        String userAgent = requestService.getUserAgent(request);
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        String fullUrl = uri + (queryString != null ? "?" + queryString : "");

        logger.info("{} HTTP Request - Metodo: {}, URI: {},  IP: {}, Dispositivo: {}",
                AppConstants.HANDLER_INI, method, fullUrl, clientIp, userAgent);

        return true;
    }
    /**
     * Importante: Metodo que MUESTRA el resultado BASE de cada peticiones HTTP, NO INCLUIR EN LOGGERs que hagan lo mismo en cada CONTROLADOR
     * JB
     * */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("{} HTTP Response completado - Status: {}, Content-Type: {}",
                AppConstants.HANDLER_FIN, response.getStatus(), response.getContentType());

        if (ex != null) {
            logger.error("Error desconocido en el handler: {}", ex.getMessage(), ex);
        }
    }
} 
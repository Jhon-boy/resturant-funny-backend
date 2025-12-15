package com.ithink.domain.config;

import com.ithink.application.services.RequestService;
import com.ithink.domain.config.trazability.UuidTrazabaility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuración de seguridad y interceptores HTTP
 * Registra interceptor para logging de peticiones HTTP
 * JB
 */
@Configuration
public class SecurityConfig implements WebMvcConfigurer {

    @Autowired
    private HttpRequestInterceptor httpRequestInterceptor;

    /**
     * Bean para el servicio de peticiones HTTP
     */
    @Bean
    public RequestService requestService() {
        return new RequestService();
    }

    /**
     * Bean para el interceptor de trazabilidad UUID
     */
    @Bean
    public UuidTrazabaility uuidTrazabaility() {
        return new UuidTrazabaility();
    }

    /**
     * Registra los interceptores en orden: UUID primero, luego HTTP logging
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(uuidTrazabaility())
                .addPathPatterns("/**")
                .order(1);

        registry.addInterceptor(httpRequestInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/isalive/**") // Excluir endpoints de isAlive
                .order(2);
    }
} 
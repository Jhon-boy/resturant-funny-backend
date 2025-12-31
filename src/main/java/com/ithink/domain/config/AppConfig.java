package com.ithink.domain.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import lombok.Data;

/**
 * Configuracion general de la aplicacion
 * JB
 * */
@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "spring.funny.config")
@Data
public class AppConfig {
	private Supabase supabase;
	
	@Data
	public static class  Supabase {
		private String url;
		private String apikey;
		private String authorization;
	}
}

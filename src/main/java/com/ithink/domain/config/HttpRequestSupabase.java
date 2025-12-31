package com.ithink.domain.config;

 

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate; 
import com.ithink.application.services.LoggerService;
import com.ithink.application.utils.Utils;

public class HttpRequestSupabase {
	final  static RestTemplate restTemplate = new RestTemplate();
	
	public String SUPABASE_URL_EXTERNAL;
	public String SUPABASE_API_KEY;
	public String SUPABASE_AUTHORIZATION;

	private LoggerService loggerService = new LoggerService();
	
	public HttpRequestSupabase() {
		loggerService.setLogger(HttpRequestSupabase.class);
	}
	/*
	 * Ejecuta una peticcion POST a SUPABASE
	 * */
	public String ejecutarPost(String body, String path) {
		loggerService.info(AppConstants.M_INI +"Path: " + path +  Utils.toJson(body));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add(AppConstants.SUPABASE_API_KEY, SUPABASE_API_KEY);
		headers.add(AppConstants.SUPABASE_AUTHORIZATION, "Bearer "+  SUPABASE_AUTHORIZATION);
		HttpEntity<String> entity = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.exchange(SUPABASE_URL_EXTERNAL + path, HttpMethod.POST, entity,
        		String.class);
        loggerService.info(AppConstants.M_FIN + response.toString());
        
        return response.toString();

	}
	
	/*
	 * Ejecuta una peticcion GET a SUPABASE
	 * */
	public String ejecutarGet( String path) {
		loggerService.info(AppConstants.M_INI + "Path: " +  Utils.toJson(path));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add(AppConstants.SUPABASE_API_KEY, SUPABASE_API_KEY);
		headers.add(AppConstants.SUPABASE_AUTHORIZATION, "Bearer "+ SUPABASE_AUTHORIZATION);
		HttpEntity<String> entity = new HttpEntity<>( headers);
        ResponseEntity<String> response = restTemplate.exchange(SUPABASE_URL_EXTERNAL + path, HttpMethod.GET, entity,
        		String.class);
        loggerService.info(AppConstants.M_FIN + response.toString());
        
        return response.getBody();

	}
}

package com.ithink.infra.adapter;

import org.springframework.stereotype.Service;

import com.ithink.application.dto.ResponseGraphQl;
import com.ithink.application.services.LoggerService;
import com.ithink.application.utils.Utils;
import com.ithink.domain.config.AppConfig;
import com.ithink.domain.config.AppConstants;
import com.ithink.domain.config.HttpRequestSupabase;
import com.ithink.domain.enums.RequestSupabase;
import com.ithink.domain.port.in.TrolPort;

@Service
public class RolPorImpl implements TrolPort {
	private LoggerService logger = new LoggerService();
	AppConfig config;
	HttpRequestSupabase httpRequestSupabase = new HttpRequestSupabase();
	
	public RolPorImpl(AppConfig config) {
		this.config = config;
		logger.setLogger(RolPorImpl.class);
		this.httpRequestSupabase.SUPABASE_API_KEY = this.config.getSupabase().getApikey();
		this.httpRequestSupabase.SUPABASE_AUTHORIZATION = this.config.getSupabase().getAuthorization();
		
	}

	@Override
	public ResponseGraphQl obtenerRolPorId(Long idRol) {
		logger.info(AppConstants.M_INI, "POR ID:" + idRol);
		ResponseGraphQl response = new ResponseGraphQl();
		StringBuilder pathBuilder = new StringBuilder(RequestSupabase.SELECT_ROLES.getPath());
		Object request = httpRequestSupabase.ejecutarGet(pathBuilder.append(idRol).toString());
		response = ResponseGraphQl.OkResponse(request);
		logger.info(AppConstants.M_INI, Utils.toJson(response));
		return response;
	}

	@Override
	public ResponseGraphQl obtenerTodosLosRoles() {
		logger.info(AppConstants.M_INI, "ROLES:");
		ResponseGraphQl response = new ResponseGraphQl();
		StringBuilder pathBuilder = new StringBuilder(RequestSupabase.SELECT_ROLES.getPath());
		Object request = httpRequestSupabase.ejecutarGet(pathBuilder.append("*").toString());
		response = ResponseGraphQl.OkResponse(request);
		logger.info(AppConstants.M_INI, Utils.toJson(response));
		return response;
	}
	
}

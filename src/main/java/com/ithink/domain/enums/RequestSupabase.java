package com.ithink.domain.enums;

import lombok.Getter;

public enum RequestSupabase {
	SELECT_ROLES("rest/v1/TROL?select=");
	
	@Getter
	private String path;
	
	RequestSupabase(String path){
		this.path = path;
	}
}

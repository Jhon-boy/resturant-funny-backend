package com.ithink.application.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Utils class for applications
 */
public class Utils {


	public static String toJson(Object obj) {
		try {
			ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			return "Error converting to JSON: " + e.getMessage();
		}
	}
}

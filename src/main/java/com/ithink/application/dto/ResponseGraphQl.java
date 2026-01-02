package com.ithink.application.dto;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ithink.domain.enums.StatusResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Class for GraphQL response
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ResponseGraphQl extends ResponseApp {
    public Object data;
    private static final ObjectMapper mapper = new ObjectMapper();

    // Ok Response default
    public static ResponseGraphQl OkResponse(Object data){
        ResponseGraphQl response = new ResponseGraphQl();
        response.setCode(StatusResponse.OK_RESPONSE.getCode());
        response.setMessage(StatusResponse.OK_RESPONSE.getDescription());
        response.setData(data);
        return response;
    }

    // Bad Response default
    public static ResponseGraphQl BadResponse(Object data){
        ResponseGraphQl response = new ResponseGraphQl();
        response.setCode(StatusResponse.BAD_RESPONSE.getCode());
        response.setMessage(StatusResponse.BAD_RESPONSE.getDescription());
        response.setData(data);
        return response;
    }
    
	/**
	 * Deserializa respuesta genérica y construye ResponseGraphQl
	 */
	public static ResponseGraphQl deserializar(Object rawResponse) {

		ResponseGraphQl response = new ResponseGraphQl();

		try {
			if (rawResponse == null) {
				return BadResponse(null);
			} 
			
			String json = rawResponse.toString().trim();

			response.setCode(StatusResponse.OK_RESPONSE.getCode());
			response.setMessage(StatusResponse.OK_RESPONSE.getDescription());

			if (json.startsWith("[")) {
				response.setData(mapper.readValue(json, new TypeReference<List<Map<String, Object>>>() {
				}));
			} else if (json.startsWith("{")) {
				response.setData(mapper.readValue(json, new TypeReference<Map<String, Object>>() {
				}));
			} else {
				response.setData(json);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return BadResponse(null);
		}

		return response;
	}

}


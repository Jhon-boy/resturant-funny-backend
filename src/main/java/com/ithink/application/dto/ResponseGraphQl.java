package com.ithink.application.dto;

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
}


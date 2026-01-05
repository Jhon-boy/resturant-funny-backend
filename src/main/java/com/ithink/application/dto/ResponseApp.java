package com.ithink.application.dto;

import com.ithink.domain.enums.StatusResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Base class for application responses
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseApp {
    public String code;
    public String message;

    public static ResponseApp okResponse(){
        ResponseApp response = new ResponseApp();
        StatusResponse status = StatusResponse.OK_RESPONSE;
        response.setCode(status.getCode());
        response.setMessage(status.getDescription());
        return  response;
    }
}


package com.ithink.domain.enums;

import com.ithink.domain.config.AppConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum StatusResponse {
    OK_RESPONSE(AppConstants.COD_OK, "PROCESS OK", 200),
    ERROR_DATOS(AppConstants.COD_ERROR_01, "ERROR, REVISE LOS DATOS DE ENVIO", 500),
    BAD_RESPONSE(AppConstants.COD_ERROR, "TRY AGAIN", 500);
    public String code;
    public String description;
    public int status;
}

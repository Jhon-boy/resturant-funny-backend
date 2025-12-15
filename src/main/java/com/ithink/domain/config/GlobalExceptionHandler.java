package com.ithink.domain.config;

import com.ithink.application.dto.ResponseGraphQl;
import com.ithink.domain.enums.StatusResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

/**
 *  Handler Global que valida los datos de entrada de los DTOs
 * JB
 * */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseGraphQl> handleValidationErrors(MethodArgumentNotValidException ex) {
        ResponseGraphQl response = new ResponseGraphQl();
        HashMap<String, Object> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        response.setCode(StatusResponse.ERROR_DATOS.getCode());
        response.setMessage(StatusResponse.BAD_RESPONSE.getDescription());
        response.setData(errors);
        return ResponseEntity.badRequest().body(response);
    }
}

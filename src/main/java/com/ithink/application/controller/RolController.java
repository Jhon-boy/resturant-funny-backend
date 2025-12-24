package com.ithink.application.controller;

import com.ithink.application.dto.CreateRolDto;
import com.ithink.application.dto.ResponseApp;
import com.ithink.application.dto.ResponseGraphQl;
import com.ithink.application.services.LoggerService;
import com.ithink.application.utils.Utils;
import com.ithink.domain.config.AppConstants;
import com.ithink.domain.port.in.TrolPort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    private final TrolPort trolPort;
    private final LoggerService loggerService = new LoggerService();

    public RolController(TrolPort trolPort){
        this.trolPort = trolPort;
        loggerService.setLogger(RolController.class);
    }

    @GetMapping("/isalive")
    public ResponseApp isALive() {
        return ResponseApp.okResponse();
    }

    @PostMapping
    public ResponseEntity<ResponseGraphQl> crearRol(@Valid @RequestBody CreateRolDto createRolDto) {
        loggerService.info(AppConstants.M_INI + " Creacion de ROL: " + Utils.toJson(createRolDto));
        ResponseGraphQl response = trolPort.crearRol(createRolDto);
        loggerService.info(AppConstants.M_FIN + " Creacion de ROL: " + Utils.toJson(response));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idRol}")
    public ResponseEntity<ResponseGraphQl> obtenerRolPorId(@PathVariable Long idRol) {
        loggerService.info(AppConstants.M_INI + " BUSCAR de ROL: " + Utils.toJson(idRol));
        ResponseGraphQl response = trolPort.obtenerRolPorId(idRol);
        loggerService.info(AppConstants.M_FIN + " BUSCAR de ROL: " + Utils.toJson(response));
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ResponseGraphQl> obtenerTodosLosRoles() {
        loggerService.info(AppConstants.M_INI + " OBTENER TODOS LOS ROLES: ");
        ResponseGraphQl response = trolPort.obtenerTodosLosRoles();
        loggerService.info(AppConstants.M_FIN + " OBTENER TODOS LOS ROLES: " + Utils.toJson(response));
        return ResponseEntity.ok(response);
    }
}

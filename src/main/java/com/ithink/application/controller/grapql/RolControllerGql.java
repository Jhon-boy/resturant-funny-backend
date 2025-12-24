package com.ithink.application.controller.grapql;

import com.ithink.application.dto.ResponseGraphQl;
import com.ithink.application.services.LoggerService;
import com.ithink.application.utils.Utils;
import com.ithink.domain.config.AppConstants;
import com.ithink.domain.port.in.TrolPort;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class RolControllerGql {

    private final TrolPort trolPort;
    private final LoggerService loggerService = new LoggerService();


    public RolControllerGql(TrolPort trolPort){
        this.trolPort = trolPort;
        loggerService.setLogger(com.ithink.application.controller.RolController.class);
    }

    // Same method name in scheme and here
    @QueryMapping
    public ResponseGraphQl findyRoleById(@Argument(name = "rolId") String idRol){
        loggerService.info(AppConstants.M_INI + " BUSCAR de ROL: " + Utils.toJson(idRol));
        ResponseGraphQl response = trolPort.obtenerRolPorId(Long.valueOf(idRol));
        loggerService.info(AppConstants.M_FIN + " BUSCAR de ROL: " + Utils.toJson(response));
        return response;
    }

    // Configure name
    @QueryMapping(name = "roles")
    public ResponseGraphQl getAllRoles(){
        loggerService.info(AppConstants.M_INI  + " OBTENIENDO ROLES" );
        ResponseGraphQl response = trolPort.obtenerTodosLosRoles();
        loggerService.info(AppConstants.M_FIN + " OBTENIENDO ROLES" + response);
        return response;
    }
}

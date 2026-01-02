package com.ithink.infra.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ithink.application.services.LoggerService;
import com.ithink.application.utils.Utils;
import com.ithink.domain.config.AppConstants;
import com.ithink.domain.port.in.TrolPort;

@Component
public class RolCronSchedule {
    private final TrolPort trolPort;
    private final LoggerService loggerService = new LoggerService();
    
    
    public RolCronSchedule(TrolPort trolPor) {
    	this.trolPort = trolPor;
    	this.loggerService.setLogger(RolCronSchedule.class);
    }
    @Scheduled(
            cron = "${spring.funny.config.cronjob.cron}",
            zone = "America/Guayaquil"
        )
    public void executeRolCron() {
    	loggerService.info(AppConstants.M_INI_CRON + "CRON JOB: executeRolCron");
    	Object response = trolPort.obtenerTodosLosRoles();
    	loggerService.info(AppConstants.M_FIN_CRON + "CRON JOB: executeRolCron" +  Utils.toJson(response));
    }
}

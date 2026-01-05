package com.ithink.domain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import graphql.scalars.ExtendedScalars;
/*
 * Configuracion para GraphQL
 * */
@Configuration
public class GraphqlConfig {

	 @Bean
	    RuntimeWiringConfigurer runtimeWiringConfigurer() {
	        return wiring -> wiring.scalar(ExtendedScalars.Json);
	    }
}

package com.school.gatewayserver;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}
	
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
	    return builder.routes()
	        .route(p -> p
	            .path("/suytry123/account/**")
	            .filters(f -> f.rewritePath("/suytry123/account/(?<segment>.*)","/${segment}")
	            		
	            		.addResponseHeader("X-RESPONSE-TIME", LocalDateTime.now().toString()))
	            				
	            .uri("lb://ACCOUNT")).
	        route(p -> p
		            .path("/suytry123/loan/**")
		            .filters(f -> f.rewritePath("/suytry123/loan/(?<segment>.*)","/${segment}"))
		            		
		            .uri("lb://LOAN")).
	        route(p -> p
		            .path("/suytry123/card/**")
		            .filters(f -> f.rewritePath("/suytry123/card/(?<segment>.*)","/${segment}"))
		            		
		            .uri("lb://CARD")).build();
	}

}

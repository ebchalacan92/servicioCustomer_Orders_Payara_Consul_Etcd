package com.distribuida.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	
	
	/*@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
	    return builder.routes()
	    		.route( p->p
	    				.path("/ServidorApp2/orders/**")
	    				.uri( "http://127.0.0.1:8091" )
	    			)
	    		.route( p->p
	    				.path("/ServidorApp1/customers/**")
	    				.uri( "http://127.0.0.1:8090" )
	    			)
	    		.build();
	}*/
}

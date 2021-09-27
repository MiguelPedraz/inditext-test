package com.company.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Main Class. 
 * Class to run application
 * 
 * @author Miguel Pedraz Hernandez
 * @version 0.1
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class ApiGatewayApplication {

	/**
     * Main method 
     * 
     * @param args
     */
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
}

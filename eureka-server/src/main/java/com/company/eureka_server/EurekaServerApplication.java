package com.company.eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Main Class. 
 * Class to run application
 * 
 * @author Miguel Pedraz Hernandez
 * @version 0.1
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

	/**
     * Main method 
     * 
     * @param args
     */
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}

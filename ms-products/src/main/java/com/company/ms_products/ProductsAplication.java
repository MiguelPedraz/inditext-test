package com.company.ms_products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
public class ProductsAplication
{
    /**
     * Main method 
     * 
     * @param args
     */
    public static void main(String[] args)
    {
    	SpringApplication.run(ProductsAplication.class, args);
    }
}

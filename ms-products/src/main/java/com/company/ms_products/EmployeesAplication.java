package com.company.ms_products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmployeesAplication
{
    public static void main(String[] args)
    {
    	SpringApplication.run(EmployeesAplication.class, args);
    }
}

package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ApiGatewayRoutesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayRoutesApplication.class, args);
	}

}

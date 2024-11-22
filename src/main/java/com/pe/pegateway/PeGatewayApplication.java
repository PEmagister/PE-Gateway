package com.pe.pegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PeGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeGatewayApplication.class, args);
	}

}

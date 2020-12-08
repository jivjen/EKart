package com.infy.ekart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EKartDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EKartDiscoveryServerApplication.class, args);
	}

}

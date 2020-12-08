package com.infy.ekart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ECartCartMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECartCartMsApplication.class, args);
	}

}

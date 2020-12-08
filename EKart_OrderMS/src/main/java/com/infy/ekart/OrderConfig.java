package com.infy.ekart;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OrderConfig {

	@Bean @LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}

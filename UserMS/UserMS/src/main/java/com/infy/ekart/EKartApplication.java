package com.infy.ekart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value= {"classpath:ValidationMessages.properties"})
public class EKartApplication {
	public static void main(String args[])
	{
		SpringApplication.run(EKartApplication.class,args);
	}
}

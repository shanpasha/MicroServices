package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
//openfeign Enable
@EnableFeignClients

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
	
//	@Bean
//	@LoadBalanced
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}
		
	
	@Bean
	public WebClient client() {
		return WebClient.builder().build();
		
	}
	

}

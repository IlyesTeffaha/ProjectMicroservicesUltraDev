package com.esprit.microservices;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
@EnableEurekaClient
public class CandidateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandidateApplication.class, args);
	}


	@Bean
	ApplicationRunner init() {
		return args -> {};
	};

}
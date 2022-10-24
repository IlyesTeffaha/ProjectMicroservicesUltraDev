package com.esprit.microservice;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;


@EnableEurekaClient
@SpringBootApplication
public class AgenceDeVoyageMicroProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgenceDeVoyageMicroProjectApplication.class, args);
	}

	
	
	

	/* ApplicationRunner init(HotelRepository repository){
		return args ->{
			Stream.of("Movenpick","Regency","hammamet").forEach(nom ->{
				repository.save(new Hotel(nom));
			});"
			repository.findAll().forEach(System.out::println);
		};
	}*/
		

	
	

	
	
	
}

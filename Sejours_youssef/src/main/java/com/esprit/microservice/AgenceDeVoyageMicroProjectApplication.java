package com.esprit.microservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.esprit.microservice.Entity.Sejour;
import com.esprit.microservice.Repository.SejourRepository;


@EnableEurekaClient
@SpringBootApplication
public class AgenceDeVoyageMicroProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgenceDeVoyageMicroProjectApplication.class, args);
	}

	
	
	
	@Bean
	/* ApplicationRunner init(HotelRepository repository){
		return args ->{
			Stream.of("Movenpick","Regency","hammamet").forEach(nom ->{
				repository.save(new Hotel(nom));
			});"
			repository.findAll().forEach(System.out::println);
		};
	}*/
		
	
	 ApplicationRunner init(SejourRepository repository){
		

		
		return args ->{
			Stream.of("Movenpick","Regency","popopo","bassas","hohoho","Aldiana").forEach(titre ->{
				repository.save(new Sejour(0, titre, null, null, 0, "jjjj",true,"description",5,10,"fkjfffkjlpz"));
			});
			repository.findAll().forEach(System.out::println);
		};
	}
	
	
	
	
	
	
}

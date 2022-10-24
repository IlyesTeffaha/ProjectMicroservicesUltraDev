package com.esprit.microservices;

import com.esprit.microservices.entities.Blog;
import com.esprit.microservices.repositories.BlogRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Stream;

@SpringBootApplication
@EnableEurekaClient
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}


	@Bean
	ApplicationRunner init(BlogRepository repository) {
		return args -> {
			Stream.of("Mariem", "Sarras", "Mohamed").forEach(title -> {
				repository.save(new Blog(title));
			});
			repository.findAll().forEach(System.out::println);
		};
	};

}
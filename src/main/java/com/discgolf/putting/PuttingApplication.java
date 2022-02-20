package com.discgolf.putting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PuttingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PuttingApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
//		return args -> {
//			Player sander = new Player("Sander", "Sepp", "sepp1300@gmail.com", 27);
//			customerRepository.save(sander);
//		};
//	}
}

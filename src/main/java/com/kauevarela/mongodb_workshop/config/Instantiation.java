package com.kauevarela.mongodb_workshop.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.kauevarela.mongodb_workshop.domain.User;
import com.kauevarela.mongodb_workshop.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		
		User kaue = new User(null, "Kaue Varela", "kaue@gmail.com");
		User caio = new User(null, "Caio César", "caio@gmail.com");
		User johnson = new User(null, "Johnson Frait", "johnson@gmail.com");
	
		userRepository.saveAll(Arrays.asList(kaue, caio, johnson));
	}

}

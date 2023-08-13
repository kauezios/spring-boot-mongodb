package com.kauevarela.mongodb_workshop.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.kauevarela.mongodb_workshop.domain.Post;
import com.kauevarela.mongodb_workshop.domain.User;
import com.kauevarela.mongodb_workshop.dto.AuthorDTO;
import com.kauevarela.mongodb_workshop.repository.PostRepository;
import com.kauevarela.mongodb_workshop.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		postRepository.deleteAll();
		userRepository.deleteAll();
		
		User kaue = new User(null, "Kaue Varela", "kaue@gmail.com");
		User caio = new User(null, "Caio César", "caio@gmail.com");
		User johnson = new User(null, "Johnson Frait", "johnson@gmail.com");
		
		userRepository.saveAll(Arrays.asList(kaue, caio, johnson));
		
		Post p1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(kaue));
		Post p2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(kaue));
	
		postRepository.saveAll(Arrays.asList(p1, p2));
		
		kaue.getPosts().addAll(Arrays.asList(p1, p2));
		userRepository.save(kaue);
	}

}

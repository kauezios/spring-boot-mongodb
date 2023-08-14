package com.kauevarela.mongodb_workshop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kauevarela.mongodb_workshop.domain.Post;
import com.kauevarela.mongodb_workshop.domain.User;
import com.kauevarela.mongodb_workshop.repository.PostRepository;
import com.kauevarela.mongodb_workshop.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
}

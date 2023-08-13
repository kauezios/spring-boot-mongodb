package com.kauevarela.mongodb_workshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kauevarela.mongodb_workshop.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}

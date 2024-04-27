package com.telusko.joblisting;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.telusko.joblisting.model.Post;
@Repository
@Component
public interface PostRepository extends MongoRepository<Post, String> {

}

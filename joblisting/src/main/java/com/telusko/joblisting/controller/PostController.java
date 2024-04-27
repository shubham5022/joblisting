package com.telusko.joblisting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.joblisting.PostRepository;
import com.telusko.joblisting.model.Post;

import jakarta.servlet.http.HttpServletResponse;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.List;

@RestController
public class PostController {
	
	
	@Autowired
	PostRepository repo;

	@ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response){
        try {
            response.sendRedirect("/swagger-ui.html");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
	
	@GetMapping("/posts")
	public List<Post> getAllPosts(){
		return repo.findAll();
		}
	
	@PostMapping("/post")
	public Post post(@RequestBody Post post) {
		return repo.save(post);
	}
}

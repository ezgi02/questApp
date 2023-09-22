package com.example.demo8.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo8.entities.Post;
import com.example.demo8.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
	private PostService postService;
	public PostController(PostService postService) {
		this.postService=postService;
	}
	@GetMapping
	public List<Post> getAllPosts(@RequestParam Optional<Long> userId){
		return postService.getAllPosts(userId);
	}
	
}

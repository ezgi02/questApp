package com.example.demo8.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo8.entities.Post;
import com.example.demo8.repos.PostRepository;

@Service
public class PostService {
	private PostRepository postRepository;
	public PostService(PostRepository postRepository) {
		this.postRepository=postRepository;
	}
	public List<Post> getAllPosts(Optional<Long> userId) {
		if(userId.isPresent())
			return postRepository.findByUserId(userId.get());
		return postRepository.findAll();
	}
}

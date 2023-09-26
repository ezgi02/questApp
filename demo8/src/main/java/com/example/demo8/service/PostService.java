package com.example.demo8.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo8.entities.Post;
import com.example.demo8.entities.User;
import com.example.demo8.repos.PostRepository;
import com.example.demo8.requests.PostCreateRequest;
import com.example.demo8.requests.PostUpdateRequest;

import jakarta.persistence.PostUpdate;

@Service
public class PostService {
	private PostRepository postRepository;
	private UserService userService;
	public PostService(PostRepository postRepository,UserService userService) {
		this.postRepository=postRepository;
		this.userService=userService;
	}
	public List<Post> getAllPosts(Optional<Long> userId) {
		if(userId.isPresent())
			return postRepository.findByUserId(userId.get());
		return postRepository.findAll();
	}
	public Post getOnePostById(Long postId) {
		return postRepository.findById(postId).orElse(null);
		
	}
	public Post createOnePost(PostCreateRequest newPostRequest) {
		User user=userService.findById(newPostRequest.getUserId());
		if(user==null) {
			return null;
		}
		Post toSave=new Post();
		toSave.setId(newPostRequest.getId());
		toSave.setText(newPostRequest.getText());
		toSave.setTitle(newPostRequest.getTitle());
		toSave.setUser(user);
		return postRepository.save(toSave);
	}
	public Post updateOnePostById(Long postId,PostUpdateRequest updatePost) {
		Optional<Post> post=postRepository.findById(postId);
		if(post.isPresent()) {
			Post toUpdate=post.get();
			toUpdate.setText(updatePost.getText());
			toUpdate.setTitle(updatePost.getTitle());
			postRepository.save(toUpdate);
			return toUpdate;
		}
		return null;
	}
	public void deleteOnePostById(Long postId) {
		postRepository.deleteById(postId);
	}
}

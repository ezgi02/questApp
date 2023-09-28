package com.example.demo8.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo8.entities.Like;
import com.example.demo8.requests.LikeCreateRequest;
import com.example.demo8.service.LikeService;

@RestController
@RequestMapping("/likes")
public class LikeController {
	@Autowired
	private LikeService likeService;
	
	@GetMapping
	public List<Like>getAllLikes(@RequestParam Optional<Long> userId,@RequestParam Optional<Long>postId){
		return likeService.getAllLikesWithParam(userId,postId);
	}
	
	@PostMapping
	public Like createOneLike(@RequestBody LikeCreateRequest request) {
		return likeService.createOneLike(request);
	}
	
	@GetMapping("/{likeId}")
	public Like getOneLike(@PathVariable Long likeId) {
		return likeService.getOneLikeById(likeId);
	}
	
	@DeleteMapping("/{likeId}")
	public void deleteOneLike(@PathVariable Long likeId) {
		likeService.deleteOneLikeById(likeId);
	}
	
	
	
}

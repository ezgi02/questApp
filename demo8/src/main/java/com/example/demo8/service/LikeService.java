package com.example.demo8.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo8.entities.Like;
import com.example.demo8.entities.Post;
import com.example.demo8.entities.User;
import com.example.demo8.repos.LikeRepository;
import com.example.demo8.requests.LikeCreateRequest;

@Service
public class LikeService {
	@Autowired
	private LikeRepository likeRepository;
	private UserService userService;
	private PostService postService;

	public List<Like> getAllLikesWithParam(Optional<Long> userId, Optional<Long> postId) {
		if (userId.isPresent() && postId.isPresent()) {
			return likeRepository.findByUserIdAndPostId(userId.get(), postId.get());
		} else if (userId.isPresent()) {
			return likeRepository.findByUserId(userId.get());
		} else if (postId.isPresent()) {
			return likeRepository.findByPostId(postId.get());
		} else {
			return likeRepository.findAll();
		}

	}

	public Like createOneLike(LikeCreateRequest request) {
		User user = userService.findById(request.getUserId());
		Post post = postService.getOnePostById(request.getPostId());
		if(user != null && post != null) {
			Like likeToSave = new Like();
			likeToSave.setId(request.getId());
			likeToSave.setPost(post);
			likeToSave.setUser(user);
			return likeRepository.save(likeToSave);
		}else		
			return null;
	}

	public Like getOneLikeById(Long likeId) {
		return likeRepository.findById(likeId).orElse(null);
	}
	public void deleteOneLikeById(Long likeId) {
		likeRepository.deleteById(likeId);
	}

}

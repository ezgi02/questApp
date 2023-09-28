package com.example.demo8.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo8.entities.Comment;
import com.example.demo8.entities.Post;
import com.example.demo8.entities.User;
import com.example.demo8.repos.CommentRepository;
import com.example.demo8.requests.CommentCreateRequest;
import com.example.demo8.requests.CommentUpdateRequest;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;
	private UserService userService;
	private PostService postService;

	public List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {
		if (userId.isPresent() && postId.isPresent()) {
			return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
		} else if (userId.isPresent()) {
			return commentRepository.findByUserId(userId.get());
		} else if (postId.isPresent()) {
			return commentRepository.findByPostId(postId.get());
		} else
			return commentRepository.findAll();
	}

	public Comment getOneCommentById(Long commentId) {
		return commentRepository.findById(commentId).orElse(null);
	}

	public Comment createOneComment(CommentCreateRequest request) {
		User user = userService.findById(request.getUserId());
		Post post = postService.getOnePostById(request.getPostId());
		if (user != null && post != null) {
			Comment commentToSave = new Comment();
			commentToSave.setId(request.getId());
			commentToSave.setPost(post);
			commentToSave.setUser(user);
			commentToSave.setText(request.getText());
			return commentRepository.save(commentToSave);
		} else
			return null;
	}

	public Comment updateCommentById(Long commentId, CommentUpdateRequest request) {
		Optional<Comment> comment=commentRepository.findById(commentId);
		if(comment.isPresent()) {
			Comment commentToUpdate=comment.get();
			commentToUpdate.setText(request.getText());
			commentRepository.save(commentToUpdate);
			return commentToUpdate;
		}else
			return null;
	}

	public void deleteOneCommentById(Long commentId) {
		commentRepository.deleteById(commentId);
	}
}

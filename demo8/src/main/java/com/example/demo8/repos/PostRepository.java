package com.example.demo8.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo8.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	List<Post> findByUserId(Long userId);

}

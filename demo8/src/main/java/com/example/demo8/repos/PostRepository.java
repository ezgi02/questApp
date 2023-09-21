package com.example.demo8.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo8.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}

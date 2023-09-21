package com.example.demo8.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo8.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

}

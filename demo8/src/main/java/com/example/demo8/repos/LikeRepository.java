package com.example.demo8.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo8.entities.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {

}

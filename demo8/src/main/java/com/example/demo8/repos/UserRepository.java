package com.example.demo8.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo8.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {

}

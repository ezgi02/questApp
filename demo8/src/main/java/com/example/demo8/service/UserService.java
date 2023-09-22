package com.example.demo8.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo8.entities.User;
import com.example.demo8.repos.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	public List<User> findAll() {
		userRepository.findAll();
		return null;
	}
	public User save(User newUser) {
		userRepository.save(newUser);
		return null;
	}
	public Optional<User> findById(Long userId) {
		userRepository.findById(userId);
		return null;
	}
	public User updateOneUser(@PathVariable Long userId,@RequestBody User newUser) {
		Optional<User> user=userRepository.findById(userId);
		if(user.isPresent()) {
			User foundUser=user.get();
			foundUser.setUsername(newUser.getUsername());
			foundUser.setPassword(newUser.getPassword());
			userRepository.save(foundUser);
			return foundUser;
		}else
			return null;
	}
	public void deleteById(Long userId) {
		userRepository.deleteById(userId);
		
	}
	
}

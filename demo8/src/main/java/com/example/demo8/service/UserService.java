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
		return userRepository.findAll();
	}
	public User save(User newUser) {
		return userRepository.save(newUser);
	
	}
	public User findById(Long userId) {
		return userRepository.findById(userId).orElse(null);
		
	}
	public User updateOneUser(@PathVariable Long userId,@RequestBody User newUser) {
		Optional<User> user=userRepository.findById(userId);
		if(user.isPresent()) {
			User foundUser=user.get();
			foundUser.setUsername(newUser.getUsername());
			foundUser.setPassword(newUser.getPassword());
			
			return userRepository.save(foundUser);
		}else
			return null;
	}
	public void deleteById(Long userId) {
		userRepository.deleteById(userId);
		
	}
	
}

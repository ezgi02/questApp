package com.example.demo8.controllers;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo8.entities.User;
import com.example.demo8.service.UserService;


@RestController
@RequestMapping("/users")

public class UserController {
	@Autowired
	private UserService userService;
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	@GetMapping
	public List<User> getAllUsers(){
		return userService.findAll();
	}
	@PostMapping
	public User createUser(@RequestBody User newUser) {
		return userService.save(newUser);
	}
	@GetMapping("/{userId}")
	public User getOneUser(@PathVariable Long userId) {
		//custom exception
		return userService.findById(userId);
	}
	@PutMapping("/{userId}")
	public User updateOneUser(@PathVariable Long userId,@RequestBody User newUser) {
		return userService.updateOneUser(userId, newUser);
	}
	@DeleteMapping("/{userId}")
	public void deleteOneUser(@PathVariable Long userId) {
		userService.deleteById(userId);
	}
	
}

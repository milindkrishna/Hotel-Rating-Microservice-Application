package com.milind.user.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milind.user.service.entities.User;
import com.milind.user.service.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userservice;
	// create
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User user1 = userservice.saveuser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
		
	}
	
	// single user get
	@GetMapping("/{userID}")
	public ResponseEntity<User> getSingleUser(@PathVariable  String userID){
		User user = userservice.getUser(userID);
		return ResponseEntity.ok(user);
	}
	
	
	// all user get
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		List<User> alluser = userservice.getAllUser();
		return ResponseEntity.ok(alluser);
		
	}
	
	
}

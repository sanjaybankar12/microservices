package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.User;
import com.spring.exception.UserNotFoundException;
import com.spring.model.UserOp;
import com.spring.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService; 

	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user) {
		return new ResponseEntity<>(this.userService.addUser(user), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserOp> getUserById(@PathVariable Integer id) throws UserNotFoundException {
		return new ResponseEntity<>(this.userService.getUser(id), HttpStatus.OK);
	}
}

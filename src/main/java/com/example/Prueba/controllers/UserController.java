package com.example.Prueba.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Prueba.models.User;
import com.example.Prueba.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public ArrayList<User> getUser(){
		return userService.getUser();
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public User save(@RequestBody User user ) {
		return this.userService.saveUser(user);
	}
	
}

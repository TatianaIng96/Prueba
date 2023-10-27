package com.example.Prueba.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Prueba.models.User;
import com.example.Prueba.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	  public ArrayList<User> getUser(){
	        return (ArrayList<User>) userRepository.findAll();
	    }

	    public User saveUser(User user){
	        return userRepository.save(user);
	    }

	    public Optional<User> getById(Long id){
	        return userRepository.findById(id);
	    }
}

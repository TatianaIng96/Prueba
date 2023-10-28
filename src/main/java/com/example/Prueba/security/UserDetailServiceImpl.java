package com.example.Prueba.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Prueba.models.User;
import com.example.Prueba.repositories.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
		User user = userRepository
				.findOneByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("el usuario" + email + "no existe"));
		
		return new UserDetailsImpl(user);
	}
}

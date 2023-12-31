package com.example.Prueba.security;

import java.io.IOException;
import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
												HttpServletResponse response){
		AuthCredencials authCredencials = new AuthCredencials();
		try {
			authCredencials = new ObjectMapper().readValue(request.getReader(), 
															AuthCredencials.class);
		}catch(IOException e){
			
		}
		
		UsernamePasswordAuthenticationToken usernamePAT = new 
				UsernamePasswordAuthenticationToken(authCredencials.getEmail(), 
									authCredencials.getPassword(), Collections.emptyList());
		
		return getAuthenticationManager().authenticate(usernamePAT);
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request,
											HttpServletResponse response, 
											FilterChain filter, 
											Authentication authResult) throws IOException, ServletException{
		UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();
		String token = TokenUtils.createToken(userDetails.getNombre(), userDetails.getUsername());
		response.addHeader("Authorization", "Bearer " + token);
		response.getWriter().flush();
		
		super.successfulAuthentication(request, response, filter, authResult);
		
	}
	
}

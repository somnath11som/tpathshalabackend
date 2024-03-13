package com.project.tpathshala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.tpathshala.component.JwtTokenUtil;
import com.project.tpathshala.payload.AuthRequest;
import com.project.tpathshala.payload.AuthResponse;
import com.project.tpathshala.repository.UserRepository;
import com.project.tpathshala.model.User;

import jakarta.validation.Valid;

@RestController
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepository userRepository;
	
	private Authentication authenticate;
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@PostMapping("/auth/login")
	public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request)
	{
		try
		{
			System.out.println("Hello");
			Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
			User user = (User) authenticate.getPrincipal();
			String accessToken = jwtTokenUtil.generateAccessToken(user);
            AuthResponse response = new AuthResponse(user.getEmail(), accessToken);
            
            return ResponseEntity.ok().body(response);
		}
		catch(BadCredentialsException ex)
		{
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
}

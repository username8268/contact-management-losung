package com.assignment.contactmanagement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.contactmanagement.service.TokenService;

@RestController
public class AuthenticationController {
	
	private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);
	
	private final TokenService tokenService;
	
	public AuthenticationController(TokenService tokenService) {
		this.tokenService = tokenService;
	}
	
	@PostMapping(value="/token")
	public String getToken(Authentication authentication) {
		
		String token = tokenService.generateToken(authentication);
		log.debug("Token generated {} : "+ token);
		return token;
	}
}

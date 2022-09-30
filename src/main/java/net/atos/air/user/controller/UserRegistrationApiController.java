package net.atos.air.user.controller;


import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.atos.air.user.dto.UserDetailsdto;
import net.atos.air.user.entity.UserDetails;
import net.atos.air.user.service.UserService;

@RestController
public class UserRegistrationApiController {
	
	@Autowired  
	UserService userService; 
	
	@Autowired
	private ModelMapper modelMapper;
	
	 @Autowired
	 private Environment env;
	 
	 @Autowired
	 ObjectMapper objectMapper;
	
	@PostMapping("/userRegistration") 
	private ResponseEntity<Map<String, String>>  userRegistration(@Valid @RequestBody UserDetailsdto users)   
	{  
		if(!userService.findByUserName(users.getUserName())) {
			userService.userRegistration(users);  
			return new ResponseEntity<Map<String, String>>(Collections.singletonMap("Success", env.getProperty("successMessage")), HttpStatus.CREATED);
		}
		else 
			return new ResponseEntity<Map<String, String>>(Collections.singletonMap("Error", env.getProperty("userexist")), HttpStatus.ALREADY_REPORTED);
	}  

	@GetMapping("/getUserDetails") 
	private List<UserDetailsdto> getAllUsers()   
	{  
		return userService.getAllUser().stream().map(post -> modelMapper.map(post, UserDetailsdto.class))
			.collect(Collectors.toList());
	}  
	
}

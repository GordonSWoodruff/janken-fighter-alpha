package com.jankenfighteralpha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jankenfighteralpha.entity.Users;
import com.jankenfighteralpha.repository.UserRepository;
import com.jankenfighteralpha.service.RegistrationService;

@CrossOrigin
@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RegistrationService register;
	
	@PostMapping(value="/saveUser",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public void submitUserDetails(@RequestBody Users user) {
		register.registerUser(user);
	}
	
	@GetMapping(value="/findUserById",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> findById(int userId) {
		Users user = userRepository.findById(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PostMapping(value="/loginUser",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> checkLogin(@RequestBody Users user) {
		Users login = userRepository.verifyLogin(user.getEmail(), user.getPassword());
		if(login != null) {
			return new ResponseEntity<>(login,HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	
}
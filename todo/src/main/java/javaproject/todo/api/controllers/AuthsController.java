package javaproject.todo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaproject.todo.business.abstracts.AuthService;
import javaproject.todo.entities.concretes.User;

@RestController
@RequestMapping("/api/verify")
@CrossOrigin
public class AuthsController {

	private AuthService authService;

	@Autowired
	public AuthsController(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping("/registerUser")
	public ResponseEntity<?> registerUser(@RequestBody User user, String confirmPassword) {
		return ResponseEntity.ok(authService.registerUser(user, confirmPassword));
	}

}

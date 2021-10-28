package javaproject.todo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaproject.todo.business.abstracts.UserService;
import javaproject.todo.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UsersController {

	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Validated @RequestBody User user) {
		return ResponseEntity.ok(this.userService.add(user));
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.userService.getAll());
	}

}

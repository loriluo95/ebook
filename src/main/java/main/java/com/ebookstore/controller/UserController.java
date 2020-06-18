package main.java.com.ebookstore.controller;

import main.java.com.ebookstore.model.User;
import main.java.com.ebookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<User> list() {
		return userService.listAll();
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<User> get(@PathVariable Integer userId) {
		try {
			User user = userService.get(userId);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/users")
	public void add(@RequestParam  String username, @RequestParam String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		userService.save(user);
	}

	@PutMapping("/users/{userId}")
	public ResponseEntity<?> update(@RequestParam  String username, @RequestParam  String password, @PathVariable Integer userId) {
		try {
			User targetUser = userService.get(userId);
			targetUser.setUsername(username);
			targetUser.setPassword(password);
			userService.save(targetUser);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/users/{userId}")
	public void delete(@PathVariable Integer userId) {
		userService.delete(userId);
	}
}

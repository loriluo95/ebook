package main.java.com.ebookstore.controller;

import main.java.com.ebookstore.UserNotFoundException;
import main.java.com.ebookstore.model.User;
import main.java.com.ebookstore.model.UserModelAssembler;
import main.java.com.ebookstore.repository.UserRepository;
import main.java.com.ebookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path="/api")
public class UserController {

	@Autowired
	private UserService userService;
	private final UserModelAssembler assembler;

	public UserController(UserModelAssembler assembler) {
		this.assembler = assembler;
	}

	@GetMapping("/users")
	public CollectionModel<EntityModel<User>> all() {
//		return userService.listAll();
		List<EntityModel<User>> employees = userService.listAll().stream() //
				.map(assembler::toModel) //
				.collect(Collectors.toList());

		return new CollectionModel(employees, linkTo(methodOn(UserController.class).all()).withSelfRel());
	}

	@GetMapping("/users/{userId}")
	public EntityModel<User> get(@PathVariable Integer userId) {
		try {
			User user = userService.get(userId);
			return assembler.toModel(user);
		} catch (NoSuchElementException e) {
			throw new UserNotFoundException();
		}
	}

	@PostMapping("/users")
	public ResponseEntity<?> add(@RequestParam  String username, @RequestParam String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
//		userService.save(user);
		EntityModel<User> entityModel = assembler.toModel(userService.save(user));
		return ResponseEntity
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(entityModel);
	}

	@PutMapping("/users/{userId}")
	public ResponseEntity<?> update(@RequestParam  String username, @RequestParam  String password, @PathVariable Integer userId) {
		try {
			User targetUser = userService.get(userId);
			targetUser.setUsername(username);
			targetUser.setPassword(password);
//			userService.save(targetUser);
//			return new ResponseEntity<>(HttpStatus.OK);
			EntityModel<User> entityModel = assembler.toModel(userService.save(targetUser));
			return ResponseEntity
					.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
					.body(entityModel);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/users/{userId}")
	public ResponseEntity<?> delete(@PathVariable Integer userId) {
		userService.delete(userId);
		return ResponseEntity.noContent().build();
	}
}

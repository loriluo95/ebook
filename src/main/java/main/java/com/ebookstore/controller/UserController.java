package main.java.com.ebookstore.controller;

import main.java.com.ebookstore.model.User;
import main.java.com.ebookstore.dao.UserDao;
import main.java.com.ebookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping(path="/user")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getAllUsers() throws IOException {
		ResponseEntity<byte[]> responseEntity = userService.getUsername();
		return responseEntity;
	}
}

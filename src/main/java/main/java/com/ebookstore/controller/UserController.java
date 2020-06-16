package main.java.com.ebookstore.controller;

import main.java.com.ebookstore.model.Users;
import main.java.com.ebookstore.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping(path="/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@PostMapping(path="/users/add")
	public @ResponseBody String addNewUser (@RequestParam String username
			, @RequestParam String password) {
		Users n = new Users();
		n.setUsername(username);
		n.setPassword(password);
		userRepository.save(n);
		return "Saved";
	}

	@GetMapping(path="/users")
	public String getAllUsers(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "index";
	}
}

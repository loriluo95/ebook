package main.java.com.ebookstore.controller;

import main.java.com.ebookstore.dao.UserRepository;
import main.java.com.ebookstore.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @RequestMapping(path="/")
    public String homePage () {
        return "index";
    }
}

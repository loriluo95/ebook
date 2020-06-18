package main.java.com.ebookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @RequestMapping(path="/")
    public String homePage () {
        return "users";
    }
}

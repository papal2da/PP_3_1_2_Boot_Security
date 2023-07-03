package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.security.Principal;

@Controller
public class UserController {
    UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/user")
    public String userView(Model model, Principal principal) {
        model.addAttribute("user", userService.findByUserName(principal.getName()));
        return "pages/showuser";
    }

//    public String getUser(@PathVariable("id") int id, Model model) {
//        model.addAttribute("user", usersService.findOne(id));
//        return "pages/showuser";
//    }
}

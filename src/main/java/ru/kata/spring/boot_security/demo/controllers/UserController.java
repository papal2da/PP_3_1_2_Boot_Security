package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.services.UserDetailsServiceImpl;

import java.security.Principal;

@Controller
public class UserController {
    UserDetailsServiceImpl userDetailsServiceImpl;
    @Autowired
    public UserController(UserDetailsServiceImpl userDetailsServiceImpl) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }
    @GetMapping("/user")
    public String userView(Model model, Principal principal) {
        model.addAttribute("user", userDetailsServiceImpl.findByUserName(principal.getName()));
        return "pages/userpage";
    }

//    public String getUser(@PathVariable("id") int id, Model model) {
//        model.addAttribute("user", usersService.findOne(id));
//        return "pages/showuser";
//    }
}

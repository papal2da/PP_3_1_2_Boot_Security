package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping()
    public String adminsPage(Model model) {
        model.addAttribute("users", userService.findAll());
        return "pages/adminspage";
    }
    @GetMapping("/getusers")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "pages/allusers";
    }

}

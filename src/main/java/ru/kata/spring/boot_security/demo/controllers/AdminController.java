package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.services.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "pages/allusers";
    }
    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findOne(id));
        return "pages/showuserforadmin";
    }

    @GetMapping("/user/new")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "pages/newuser";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user
            , BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "pages/newuser";
        }
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/user/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findOne(id));
        return "pages/edit";
    }

    @PatchMapping("/user/{id}")
    public String update(@PathVariable("id") Long id
            , @ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "pages/edit";
        }
        userService.update(id, user);
        return "redirect:/admin";
    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") int id) {
//        usersService.delete(id);
//        return "redirect:/user";
//    }

}

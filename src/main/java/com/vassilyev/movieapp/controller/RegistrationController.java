package com.vassilyev.movieapp.controller;

import com.vassilyev.movieapp.model.web.User;
import com.vassilyev.movieapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registrationForm(User user) {
        return "registration.html";
    }

    @PostMapping("/registration")
    public String regUser(@Valid User user,
                          BindingResult bindingResult,
                          Model model) {
        if(bindingResult.hasErrors()) {
            return "registration";
        }
        if (userService.saveUser(user)) {
            return "redirect:/login";
        } else {
            model.addAttribute("regError", "Такой пользователь уже зарегистрирован :(");
            return "registration.html";
        }
    }
}

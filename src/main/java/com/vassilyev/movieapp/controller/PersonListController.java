package com.vassilyev.movieapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonListController {


    @GetMapping("/info")
    public String info(Model model) {
        return "person_list";
    }

}

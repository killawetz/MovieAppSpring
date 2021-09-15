package com.vassilyev.movieapp.controller;

import com.vassilyev.movieapp.model.Film;
import com.vassilyev.movieapp.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AdminController {


    @Autowired
    private FilmService filmService;

    @GetMapping("/add_movie")
    public String show(Model model) {
        model.addAttribute("film", new Film());
        return "add_movie";
    }

    @PostMapping("/add_movie")
    public String addMovie(@ModelAttribute @Valid Film film,
                           BindingResult bindingResult,
                           Model model) {
        if(bindingResult.hasErrors()) {
            return "add_movie";
        }
        filmService.save(film);
        model.addAttribute("film", film);

        return "redirect:/movies";
    }
}

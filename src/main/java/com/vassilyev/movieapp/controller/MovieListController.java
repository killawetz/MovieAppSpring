package com.vassilyev.movieapp.controller;

import com.vassilyev.movieapp.model.Film;
import com.vassilyev.movieapp.model.Screenshot;
import com.vassilyev.movieapp.repository.FilmRepository;
import com.vassilyev.movieapp.repository.GenreRepository;
import com.vassilyev.movieapp.repository.ScreenshotRepository;
import com.vassilyev.movieapp.service.ScreenshotService;
import com.vassilyev.movieapp.service.impl.ScreenshotServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class MovieListController {

    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private GenreRepository genreRepository;
    final ScreenshotService screenshotService;

    @Autowired
    public MovieListController(ScreenshotService screenshotService) {
        this.screenshotService = screenshotService;
    }

    @GetMapping("/movies")
    public String info(Model model) {
        List<Film> films = (List<Film>) filmRepository.findAll();
        /*HashMap<Film, Screenshot> filmScreenshotMap = screenshotService.findScreenListByFilms(films);*/
        model.addAttribute("films", films);

        List<Screenshot> screenshots = screenshotService.findAll();
        model.addAttribute("genres", genreRepository.findAll());
        return "movie_list";
    }



    @PostMapping("/selectedMovie")
    public String showMethod(@RequestParam(name="id", required=false) Long filmId, Model model) {
        model.addAttribute("selectedMovie", filmRepository.findById(filmId).get());
        return "selected_movie";
    }



}

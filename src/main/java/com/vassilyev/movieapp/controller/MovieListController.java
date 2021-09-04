package com.vassilyev.movieapp.controller;

import com.vassilyev.movieapp.model.Film;
import com.vassilyev.movieapp.model.Screenshot;
import com.vassilyev.movieapp.repository.FilmRepository;
import com.vassilyev.movieapp.repository.ScreenshotRepository;
import com.vassilyev.movieapp.service.ScreenshotService;
import com.vassilyev.movieapp.service.impl.ScreenshotServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Controller
public class MovieListController {

    @Autowired
    private FilmRepository filmRepository;

    final ScreenshotService screenshotService;

    @Autowired
    public MovieListController(ScreenshotService screenshotService) {
        this.screenshotService = screenshotService;
    }

    @GetMapping("/movies")
    public String info(Model model) {
        List<Film> films = new ArrayList<>();
        films = (List<Film>) filmRepository.findAll();
        HashMap<Film, Screenshot> filmScreenshotMap = screenshotService.findScreenListByFilms(films);
        model.addAttribute("filmMap", filmScreenshotMap);

       /* Set<Film> filmSet = filmScreenshotMap.keySet();
        for(Film key: filmSet) {
            filmScreenshotMap.get(key).getUrl();
        }*/
        model.addAttribute("listOfKeys", filmScreenshotMap.keySet());
        return "movie_list";
    }

    @GetMapping("/add_movie")
    public String addMovie(Model model) {


        return "add_movie";
    }


}

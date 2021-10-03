package com.vassilyev.movieapp.controller;

import com.vassilyev.movieapp.model.Film;
import com.vassilyev.movieapp.model.PersonAward;
import com.vassilyev.movieapp.model.PersonInFilm;
import com.vassilyev.movieapp.model.Screenshot;
import com.vassilyev.movieapp.repository.FilmRepository;
import com.vassilyev.movieapp.repository.GenreRepository;
import com.vassilyev.movieapp.repository.PersonAwardRepository;
import com.vassilyev.movieapp.service.ScreenshotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MovieListController {

    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private GenreRepository genreRepository;
    final ScreenshotService screenshotService;
    @Autowired
    private PersonAwardRepository personAwardRepository;

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


        return "movie_list";
    }


    @PostMapping("/selectedMovie")
    public String showMethod(@RequestParam(name="id") Long filmId, Model model) {
        Film selectedFilm = filmRepository.findById(filmId).get();
        model.addAttribute("selectedMovie", selectedFilm);
        model.addAttribute("peopleInFilm", selectedFilm.getPersonInFilms());
        List<PersonAward> personAwardList = new ArrayList<>();
        for (PersonInFilm pif: selectedFilm.getPersonInFilms()) {
            personAwardList.addAll(pif.getPersonAwards());
        }
        System.out.println("ПЕРСОН " + personAwardList);
        model.addAttribute("personAwardList", personAwardList);
        return "selected_movie_info";
    }



}

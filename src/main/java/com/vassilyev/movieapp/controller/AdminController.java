package com.vassilyev.movieapp.controller;

import com.vassilyev.movieapp.model.Country;
import com.vassilyev.movieapp.model.Film;
import com.vassilyev.movieapp.model.Genre;
import com.vassilyev.movieapp.model.Studio;
import com.vassilyev.movieapp.repository.CountryRepository;
import com.vassilyev.movieapp.repository.GenreRepository;
import com.vassilyev.movieapp.repository.StudioRepository;
import com.vassilyev.movieapp.service.CountryService;
import com.vassilyev.movieapp.service.FilmService;
import com.vassilyev.movieapp.service.GenreService;
import com.vassilyev.movieapp.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminController {


    @Autowired
    private FilmService filmService;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private GenreService genreService;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private CountryService countryService;
    @Autowired
    private StudioRepository studioRepository;
    @Autowired
    private StudioService studioService;

    @GetMapping("/add_movie")
    public String show(Model model) {
        List<Genre> genreList = (List<Genre>) genreRepository.findAll();
        List<Country> countries = (List<Country>) countryRepository.findAll();
        List<Studio> studious = (List<Studio>) studioRepository.findAll();
        model.addAttribute("film", new Film());
        model.addAttribute("genreList", genreList);
        model.addAttribute("countryList", countries);
        model.addAttribute("studioList", studious);



        return "add_movie";
    }

    @PostMapping("/add_movie")
    public String addMovie(@ModelAttribute @Valid Film film,
                           @RequestParam("filmGenres") String[] genres,
                           @RequestParam("filmCountries") String[] countries,
                           @RequestParam("filmStudious") String[] studious,
                           BindingResult bindingResult,
                           Model model) {
        if(bindingResult.hasErrors()) {
            return "add_movie";
        }
        film.setGenres(genreService.findByNameArray(genres));
        film.setCountries(countryService.findByNameArray(countries));
        film.setStudios(studioService.findByNameArray(studious));
        filmService.save(film);
        model.addAttribute("film", film);

        return "redirect:/movies";
    }
}

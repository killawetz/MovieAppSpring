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
import org.springframework.validation.annotation.Validated;
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
    public String addMovie(@RequestParam(value = "filmGenres", required = false) String[] genres,
                           @RequestParam(value = "filmCountries", required = false) String[] countries,
                           @RequestParam(value = "filmStudious", required = false) String[] studious,
                           @ModelAttribute @Valid Film film,
                           BindingResult bindingResult,
                           Model model) {
        if (bindingResult.hasErrors()) {
            return "add_movie";
        }
        if (genres != null) {
            film.setGenres(genreService.findByNameArray(genres));
        }
        if (countries != null) {
            film.setCountries(countryService.findByNameArray(countries));
        }
        if (studious != null) {
            film.setStudios(studioService.findByNameArray(studious));
        }
        filmService.save(film);
        model.addAttribute("film", film);

        return "redirect:/movies";
    }
}

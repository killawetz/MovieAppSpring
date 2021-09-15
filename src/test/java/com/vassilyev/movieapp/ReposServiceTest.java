package com.vassilyev.movieapp;

import com.vassilyev.movieapp.model.Film;
import com.vassilyev.movieapp.model.web.User;
import com.vassilyev.movieapp.repository.FilmRepository;
import com.vassilyev.movieapp.service.FilmService;
import com.vassilyev.movieapp.service.UserService;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.SQLOutput;

@SpringBootTest
public class ReposServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    FilmService filmService;

    @Test
    void tryScreenshot() {
        User user = (User) userService.loadUserByUsername("123");
        String cur = bCryptPasswordEncoder.encode("roman");
        String cur1 = bCryptPasswordEncoder.encode(cur);
        String cur2 = bCryptPasswordEncoder.encode("roman");
        System.out.println(bCryptPasswordEncoder.matches("123", user.getPassword()));
        System.out.println();
    }

    @Test
    void multiplyAccess() {
        Long filmId = 363L;
        Film selectedFilm = filmService.findById(filmId);
        System.out.println(selectedFilm.getName());
        System.out.println(selectedFilm.getGenres());
        System.out.println(selectedFilm.getCountries().toString());
        System.out.println(selectedFilm.getStudios().toString());
        System.out.println(selectedFilm.getPersonInFilms().toString());
    }

    @Test
    void screenTest() {
        Long filmId = 4L;
        System.out.println(filmRepository.findById(filmId).get().getScreenshots().get(0).getUrl());
    }
}

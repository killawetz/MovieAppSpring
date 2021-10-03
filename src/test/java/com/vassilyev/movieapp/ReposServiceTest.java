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

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Test
    void screenTest() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

       Film film = filmRepository.findById(11L).get();
        System.out.println(film.getPersonInFilms());;
    }


}

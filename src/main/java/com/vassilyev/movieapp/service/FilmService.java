package com.vassilyev.movieapp.service;

import com.vassilyev.movieapp.model.Film;

import javax.transaction.Transactional;
import java.util.List;

public interface FilmService {

    void delete(Film film);
    Film findFilmByName(String name);
    List<Film> findAll();
    Film findById(Long id);
    void save(Film film);
}

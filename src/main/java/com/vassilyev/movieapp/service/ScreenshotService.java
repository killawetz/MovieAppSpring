package com.vassilyev.movieapp.service;

import com.vassilyev.movieapp.model.Film;
import com.vassilyev.movieapp.model.Screenshot;

import java.util.HashMap;
import java.util.List;

public interface ScreenshotService {

    void delete(Screenshot screenshot);

    void deleteByFilmId(Film film);

    HashMap<Film, Screenshot> findScreenListByFilms(List<Film> films);

    List<Screenshot> findAll();
}

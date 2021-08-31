package com.vassilyev.movieapp.service.impl;

import com.vassilyev.movieapp.model.Film;
import com.vassilyev.movieapp.model.Screenshot;
import com.vassilyev.movieapp.repository.ScreenshotRepository;
import com.vassilyev.movieapp.service.ScreenshotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Service
public class ScreenshotServiceImpl implements ScreenshotService {

    @Autowired
    private ScreenshotRepository screenshotRepository;

    @Override
    public void delete(Screenshot screenshot) {
        screenshotRepository.delete(screenshot);
    }

    @Override
    public void deleteByFilmId(Film film) {
        screenshotRepository.deleteByFilmId(film);
    }

    @Override
    public HashMap<Film, Screenshot> findScreenListByFilms(List<Film> films) {
        HashMap<Film, Screenshot> filmScreenshotMap = new HashMap<>();
        for(Film film: films) {
            Screenshot screenshot = screenshotRepository.findByFilmId(film);
            filmScreenshotMap.put(film, screenshot);
        }
        return filmScreenshotMap;
    }
}

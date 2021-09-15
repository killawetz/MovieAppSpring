package com.vassilyev.movieapp.service.impl;

import com.vassilyev.movieapp.model.Film;
import com.vassilyev.movieapp.repository.FilmRepository;
import com.vassilyev.movieapp.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public void delete(Film film) {
        filmRepository.delete(film);
    }

    @Override
    public Film findFilmByName(String name) {
        return filmRepository.findFilmByName(name);
    }

    @Override
    public List<Film> findAll() {
        return (List<Film>) filmRepository.findAll();
    }

    @Override
    public Film findById(Long id) {
       return filmRepository.findById(id).get();
    }

    @Override
    public void save(Film film) {
        Film bufferFilm = findFilmByName(film.getName());
        if(bufferFilm != null && bufferFilm.getYear() == film.getYear()) {
            System.out.println("Такой фильм уже сущетсвует в базе данных");
        }
            filmRepository.save(film);
    }
}

package com.vassilyev.movieapp.repository;

import com.vassilyev.movieapp.model.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film, Long> {

    Film findFilmByName (String name);
}

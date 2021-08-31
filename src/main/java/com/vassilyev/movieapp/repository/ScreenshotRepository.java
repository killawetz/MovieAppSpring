package com.vassilyev.movieapp.repository;

import com.vassilyev.movieapp.model.Film;
import com.vassilyev.movieapp.model.Screenshot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScreenshotRepository extends CrudRepository<Screenshot, Long> {

    Screenshot findByFilmId(Film film);

    void deleteByFilmId(Film film);
/*
    List<Screenshot> findAllByFilmi(Film)
*/
}

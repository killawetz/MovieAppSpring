package com.vassilyev.movieapp.repository;

import com.vassilyev.movieapp.model.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {

    boolean existsGenreByName(String name);

    Genre findByName(String name);
}

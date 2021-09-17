package com.vassilyev.movieapp.repository;

import com.vassilyev.movieapp.model.Genre;
import com.vassilyev.movieapp.model.Studio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepository extends CrudRepository<Studio, Long> {
    Studio findByName(String name);

}

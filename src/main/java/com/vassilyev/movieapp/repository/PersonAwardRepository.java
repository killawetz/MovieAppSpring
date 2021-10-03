package com.vassilyev.movieapp.repository;

import com.vassilyev.movieapp.model.PersonAward;
import com.vassilyev.movieapp.model.PersonAwardId;
import com.vassilyev.movieapp.model.PersonInFilm;
import org.springframework.data.repository.CrudRepository;

public interface PersonAwardRepository extends CrudRepository<PersonAward, Long> {

    PersonAward findPersonAwardByPersonInFilm(PersonInFilm personInFilm);
}

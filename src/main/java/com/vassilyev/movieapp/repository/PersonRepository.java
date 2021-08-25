package com.vassilyev.movieapp.repository;

import com.vassilyev.movieapp.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}

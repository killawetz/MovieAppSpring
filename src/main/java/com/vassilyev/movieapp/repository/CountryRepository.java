package com.vassilyev.movieapp.repository;

import com.vassilyev.movieapp.model.Country;
import com.vassilyev.movieapp.model.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
    Country findByName(String name);

}

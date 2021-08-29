package com.vassilyev.movieapp.repository;

import com.vassilyev.movieapp.model.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {
}

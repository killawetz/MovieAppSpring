package com.vassilyev.movieapp.service;

import com.vassilyev.movieapp.model.Country;
import com.vassilyev.movieapp.model.Genre;

import java.util.List;

public interface CountryService {

    List<Country> findByNameArray(String[] nameArray);
}

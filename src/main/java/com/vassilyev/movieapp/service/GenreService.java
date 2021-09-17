package com.vassilyev.movieapp.service;

import com.vassilyev.movieapp.model.Genre;

import java.util.List;

public interface GenreService {

    List<Genre> findByNameArray(String[] nameArray);
}

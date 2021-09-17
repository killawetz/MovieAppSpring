package com.vassilyev.movieapp.service.impl;

import com.vassilyev.movieapp.model.Genre;
import com.vassilyev.movieapp.repository.GenreRepository;
import com.vassilyev.movieapp.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<Genre> findByNameArray(String[] nameArray) {
        List<Genre> genres = new ArrayList<>();
        for (int i = 0; i < nameArray.length; i++) {
            genres.add(genreRepository.findByName(nameArray[i]));
        }
        return genres;
    }
}

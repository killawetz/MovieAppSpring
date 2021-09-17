package com.vassilyev.movieapp.service;

import com.vassilyev.movieapp.model.Genre;
import com.vassilyev.movieapp.model.Studio;

import java.util.List;

public interface StudioService {

    List<Studio> findByNameArray(String[] nameArray);
}

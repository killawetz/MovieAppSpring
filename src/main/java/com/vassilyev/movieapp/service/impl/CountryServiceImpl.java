package com.vassilyev.movieapp.service.impl;

import com.vassilyev.movieapp.model.Country;
import com.vassilyev.movieapp.model.Genre;
import com.vassilyev.movieapp.repository.CountryRepository;
import com.vassilyev.movieapp.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;
    @Override
    public List<Country> findByNameArray(String[] nameArray) {
        List<Country> countries = new ArrayList<>();
        for (int i = 0; i < nameArray.length; i++) {
            countries.add(countryRepository.findByName(nameArray[i]));
        }
        return countries;
    }
}

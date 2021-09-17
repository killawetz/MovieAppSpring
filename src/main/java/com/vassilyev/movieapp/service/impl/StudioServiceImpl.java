package com.vassilyev.movieapp.service.impl;

import com.vassilyev.movieapp.model.Country;
import com.vassilyev.movieapp.model.Studio;
import com.vassilyev.movieapp.repository.StudioRepository;
import com.vassilyev.movieapp.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudioServiceImpl implements StudioService {
    @Autowired
    private StudioRepository studioRepository;
    @Override
    public List<Studio> findByNameArray(String[] nameArray) {
        List<Studio> studious = new ArrayList<>();
        for (int i = 0; i < nameArray.length; i++) {
            studious.add(studioRepository.findByName(nameArray[i]));
        }
        return studious;
    }
}

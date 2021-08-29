package com.vassilyev.movieapp.repository;

import com.vassilyev.movieapp.model.Studio;
import org.springframework.data.repository.CrudRepository;

public interface StudioRepository extends CrudRepository<Studio, Long> {
}

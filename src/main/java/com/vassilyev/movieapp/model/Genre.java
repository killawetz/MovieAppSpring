package com.vassilyev.movieapp.model;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "genre_name", nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "genres", cascade = CascadeType.ALL)
    private List<Film> films = new ArrayList<>();

    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public List<Film> getFilms() {
        return films;
    }
}
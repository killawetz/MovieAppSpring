package com.vassilyev.movieapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "position", nullable = false, unique = true)
    private String position;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<PersonInFilm> personInFilms = new HashSet<>();

    public Role() {
    }

    public Role(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}


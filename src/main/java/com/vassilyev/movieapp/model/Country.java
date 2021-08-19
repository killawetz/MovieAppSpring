package com.vassilyev.movieapp.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country_name", nullable = false, unique = true)
    private String name;


    public Country() {
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

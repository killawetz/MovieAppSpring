package com.vassilyev.movieapp.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Studio {

    public Studio() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "studio_name", nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "studios")
    private List<Film> films;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

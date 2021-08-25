package com.vassilyev.movieapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Studio {

    public Studio() {
    }

    public Studio(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "studio_name", nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "studios", cascade = CascadeType.ALL)
    private List<Film> films = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

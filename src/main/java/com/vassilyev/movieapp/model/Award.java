package com.vassilyev.movieapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Award {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "award_name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "award")
    private List<PersonAward> personAwards = new ArrayList<>();

    public Award() {
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

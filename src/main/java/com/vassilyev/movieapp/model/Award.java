package com.vassilyev.movieapp.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Award {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "award_name", nullable = false, unique = true)
    private String name;


    @OneToMany(
            mappedBy = "award",
            orphanRemoval = true,
            cascade = CascadeType.REMOVE
    )
    private List<PersonAward> personAwards;

    public Award() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
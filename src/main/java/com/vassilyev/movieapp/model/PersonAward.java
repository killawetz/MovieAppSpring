package com.vassilyev.movieapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class PersonAward {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "personAwards")
    private List<PersonInFilm> personInFilms = new ArrayList<>();

    @ManyToOne
    private Award award;


    /*@EmbeddedId
    private PersonAwardId id;

    @ManyToOne
    @MapsId("personInFilmId")
    private PersonInFilm personInFilm;

    @ManyToOne
    @MapsId("awardId")
    private Award award;*/

    @Column(name = "isReceived")
    private boolean isReceived;


    public PersonAward() {}

    public void setPersonInFilms(List<PersonInFilm> personInFilms) {
        this.personInFilms = personInFilms;
    }

    public void setAward(Award award) {
        this.award = award;
    }

    public void setReceived(boolean received) {
        isReceived = received;
    }

    public List<PersonInFilm> getPersonInFilms() {
        return personInFilms;
    }

    public Award getAward() {
        return award;
    }

    public boolean isReceived() {
        return isReceived;
    }
}

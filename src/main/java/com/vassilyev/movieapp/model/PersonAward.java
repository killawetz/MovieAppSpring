package com.vassilyev.movieapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class PersonAward implements Serializable {


    @Id
    @ManyToOne
    private PersonInFilm personInFilm;

    @Id
    @ManyToOne
    private Award award;

    @Column(name = "isReceived")
    private boolean isReceived;

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "personAwards")
    private List<PersonInFilm> personInFilms = new ArrayList<>();

    @ManyToOne
    private Award award;*/


    /*@EmbeddedId
    private PersonAwardId id;

    @ManyToOne
    @MapsId("personInFilmId")
    private PersonInFilm personInFilm;

    @ManyToOne
    @MapsId("awardId")
    private Award award;*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonAward that = (PersonAward) o;
        return Objects.equals(personInFilm, that.personInFilm) && Objects.equals(award, that.award);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personInFilm, award);
    }
}

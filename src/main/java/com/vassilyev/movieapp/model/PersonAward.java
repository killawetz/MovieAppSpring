package com.vassilyev.movieapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class PersonAward implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private PersonInFilm personInFilm;

    @ManyToOne
    private Award award;

    @Column(name = "isReceived")
    private boolean isReceived;

    public PersonInFilm getPersonInFilm() {
        return personInFilm;
    }

    public void setPersonInFilm(PersonInFilm personInFilm) {
        this.personInFilm = personInFilm;
    }

    public Award getAward() {
        return award;
    }

    public void setAward(Award award) {
        this.award = award;
    }

    public boolean isReceived() {
        return isReceived;
    }

    public void setReceived(boolean received) {
        isReceived = received;
    }

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

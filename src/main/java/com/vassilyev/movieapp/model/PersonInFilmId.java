package com.vassilyev.movieapp.model;


import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PersonInFilmId implements Serializable {

    private Long personId;

    private Long filmId;

    private Long roleId;

    public PersonInFilmId() {}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonInFilmId that = (PersonInFilmId) o;
        return Objects.equals(personId, that.personId) && Objects.equals(filmId, that.filmId) && Objects.equals(roleId, that.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, filmId, roleId);
    }
}
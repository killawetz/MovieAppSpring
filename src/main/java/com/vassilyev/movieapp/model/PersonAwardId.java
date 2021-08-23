package com.vassilyev.movieapp.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PersonAwardId implements Serializable {

    private Long personInFilmId;

    private Long awardId;

    public PersonAwardId() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonAwardId that = (PersonAwardId) o;
        return Objects.equals(personInFilmId, that.personInFilmId) && Objects.equals(awardId, that.awardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personInFilmId, awardId);
    }
}
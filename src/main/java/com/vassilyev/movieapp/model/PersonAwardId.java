package com.vassilyev.movieapp.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


/*
Hibernate does allow composite identifiers to be defined
without a "primary key class" via multiple @Id attributes.
 */
@Embeddable
public class PersonAwardId implements Serializable {

    private Long personIdInFilm;

    private Long awardId;

    public PersonAwardId() {
    }

    public PersonAwardId(Long person_id, Long award_id) {
        this.personIdInFilm = person_id;
        this.awardId = award_id;
    }

    public Long getPerson_id() {
        return personIdInFilm;
    }

    public Long getAward_id() {
        return awardId;
    }

    public void setPerson_id(Long person_id) {
        this.personIdInFilm = person_id;
    }

    public void setAward_id(Long award_id) {
        this.awardId = award_id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonAwardId that = (PersonAwardId) o;
        return Objects.equals(personIdInFilm, that.awardId)
                && Objects.equals(awardId, that.awardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personIdInFilm, awardId);
    }
}

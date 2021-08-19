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

    @Column(name = "person_id")
    private Long person_in_film_id;

    @Column(name = "award_id")
    private Long award_id;

    public PersonAwardId() {
    }

    public PersonAwardId(Long person_id, Long award_id) {
        this.person_in_film_id = person_id;
        this.award_id = award_id;
    }

    public Long getPerson_id() {
        return person_in_film_id;
    }

    public Long getAward_id() {
        return award_id;
    }

    public void setPerson_id(Long person_id) {
        this.person_in_film_id = person_id;
    }

    public void setAward_id(Long award_id) {
        this.award_id = award_id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonAwardId that = (PersonAwardId) o;
        return Objects.equals(person_in_film_id, that.person_in_film_id) && Objects.equals(award_id, that.award_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person_in_film_id, award_id);
    }
}

package com.vassilyev.movieapp.model;

import javax.persistence.*;

@Entity
public class Screenshot {
    public Screenshot() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url", nullable = false, unique = true)
    private String url;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "film_id", referencedColumnName = "id", nullable = false)
    private Film filmId;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setFilmId(Film filmId) {
        this.filmId = filmId;
    }

    public String getUrl() {
        return url;
    }

    public Film getFilmId() {
        return filmId;
    }
}

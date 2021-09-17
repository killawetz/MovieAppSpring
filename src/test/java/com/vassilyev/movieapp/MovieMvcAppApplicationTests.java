package com.vassilyev.movieapp;

import com.vassilyev.movieapp.model.*;
import com.vassilyev.movieapp.repository.*;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;

@SpringBootTest
class MovieMvcAppApplicationTests {

	@Test
	void testDB() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		Country canada = new Country("Canada");

		entityManager.persist(canada);
		Country russia = new Country("Russia");
		Country german = new Country("German");

		Studio paramountStudio = new Studio("Paramount");
		Studio disneyStudio = new Studio("Disney");

		Genre comedyGenre = new Genre("Comedy");
		Genre thrillerGenre = new Genre("Thriller");

		Person personJames = new Person("James Potter",
				canada,
				java.sql.Date.valueOf("2005-01-12"));

		Person personRoma = new Person("Roman Vassilyev",
				russia,
				java.sql.Date.valueOf("1998-09-22"));

	}

	@Autowired
	private EntityManagerFactory entityManagerFactory;


	@Test
	public void tryToDelete() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		Country canada = new Country("Canada");

		Person personJames = new Person("James Potter",
				canada,
				java.sql.Date.valueOf("2005-01-12"));

		entityManager.remove(personJames);

		entityManager.flush();

		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private GenreRepository genreRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private StudioRepository studioRepository;
	@Test
	public void tryRepo() {
		Genre dramaGenre = new Genre("Drama");


		if(!genreRepository.existsGenreByName(dramaGenre.getName())) {
			genreRepository.save(dramaGenre);
		}

		System.out.println("Genre is find?: " + genreRepository.findById(1L).get().getName());
		System.out.println("Genre is find?: " + genreRepository.findById(2L).get().getName());
	}


}

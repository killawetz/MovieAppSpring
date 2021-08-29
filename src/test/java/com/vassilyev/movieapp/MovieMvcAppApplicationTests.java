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

	@Autowired
	private EntityManagerFactory entityManagerFactory;

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

		Film film1 = new Film("Knocking on Heavens Door",
				"Germany film about two guys",
				400000,
				1999,
				123);

		film1.getCountries().add(german);
		film1.getStudios().add(disneyStudio);
		film1.getGenres().add(comedyGenre);
		film1.getGenres().add(thrillerGenre);

		Role directorRole = new Role("Director");
		Role actorRole = new Role("Actor");
		Role operatorRole = new Role("Operator");

		PersonInFilm personInFilm1 = new PersonInFilm(personJames,
				film1,
				directorRole);

		PersonInFilm personInFilm2 = new PersonInFilm(personRoma,
				film1,
				operatorRole);

		personJames.getPersonInFilms().add(personInFilm1);
		personJames.getPersonInFilms().add(personInFilm2);

		entityManager.persist(personJames);
		entityManager.persist(personRoma);
		entityManager.persist(disneyStudio);
		entityManager.persist(paramountStudio);
		entityManager.persist(thrillerGenre);
		entityManager.persist(comedyGenre);
		entityManager.persist(canada);
		entityManager.persist(russia);
		entityManager.persist(german);
		entityManager.persist(film1);
		entityManager.persist(actorRole);
		entityManager.persist(directorRole);
		entityManager.persist(operatorRole);
		entityManager.persist(personInFilm1);
		entityManager.persist(personInFilm2);


		entityManager.flush();
		entityManager.getTransaction().commit();

		System.out.println(canada);

	}


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

	@Test
	public void manyToManyTest() {
		Film film1 = new Film("Pulp Fiction",
				"Tarantino is god",
				123123,
				1994,
				145);

		String selectedFilmName = "Knocking on Heavens Door";
		String selectedGenreName = "Comedy";

/*
		Film film1 = filmRepository.findFilmByName(selectedFilmName);
*/

		if(genreRepository.existsGenreByName(selectedGenreName)) {
			Genre currentGenre = genreRepository.findByName(selectedGenreName);
			film1.getGenres().add(currentGenre);
			System.out.println(currentGenre.getName());
			filmRepository.save(film1);
		}


		System.out.println(filmRepository.findById(7L).get().getGenres().toString());

	}

}

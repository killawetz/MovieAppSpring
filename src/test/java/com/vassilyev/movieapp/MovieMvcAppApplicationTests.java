package com.vassilyev.movieapp;

import com.vassilyev.movieapp.model.Award;
import com.vassilyev.movieapp.model.Country;
import com.vassilyev.movieapp.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

@SpringBootTest
class MovieMvcAppApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void cascadeDelete() {
		Country canada = new Country("Canada");
		Country russia = new Country("Russia");

		Person personJames = new Person("James Potter",
				canada,
				new Date("12-12-1998"));

		Person personRoma = new Person("Roman Vassilyev",
				russia,
				new Date("12-12-1998"));

		EntityManager em = getEntityManager();


	}

}

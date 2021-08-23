package com.vassilyev.movieapp;

import com.vassilyev.movieapp.model.Award;
import com.vassilyev.movieapp.model.Country;
import com.vassilyev.movieapp.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootTest
class MovieMvcAppApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void cascadeDelete() {
	}

}

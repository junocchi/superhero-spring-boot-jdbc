package com.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import com.dto.entity.Organisation;
import com.dto.entity.Superhero;
import com.model.persistence.SuperheroDao;

@ActiveProfiles("test")
@SpringBootTest
class SuperheroDaoTests {

	@Autowired
	private SuperheroDao superheroDao;

//	@AfterEach
//	public void tearDown() {
//		// Reset or clean up any data that was saved during the test
//		// This ensures that the database is not affected by the tests
//		superheroDao.deleteSuperheroById(125); // Delete the superhero with ID 125
//	}

	// UPDATE Superhero By Id - Test 01
	@Test
	public void updateSuperheroById01() {
		Superhero superhero = new Superhero();
		superhero.setSuperheroId(13);
		superhero.setSuperheroName("NewBatgirl");
		superhero.setSuperheroDescription("Skilled detective and vigilante to protect her city.");
		superhero.setSuperheroSuperpower("Technological expertise.");

		boolean result = superheroDao.updateSuperhero(superhero);

		assertEquals(1, result);
	}

	// UPDATE Superhero By Id - test 02
	@Test
	public void updateSuperhero02() {
		Superhero superhero = new Superhero();
		superhero.setSuperheroId(333);
		superhero.setSuperheroName("NewBatgirl");
		superhero.setSuperheroDescription("Skilled detective and vigilante to protect her city.");
		superhero.setSuperheroSuperpower("Technological expertise.");

		boolean result = superheroDao.updateSuperhero(superhero);
		assertEquals(0, result);
	}

	// DELETE Superhero by Id
	@Test
	public void deleteSuperhero01() {

		int superheroId = 2;

		assertTrue(superheroDao.deleteSuperheroById(superheroId));
	}

	// DELETE Superhero by Id that does not exist
	@Test
	public void deleteSuperhero02() {
		int superheroId = 222;
		assertFalse(superheroDao.deleteSuperheroById(superheroId));
	}

	// ADD superhero - positive scenario - Test01
	@Test
	public void addSuperHeroTest01() {
		Superhero superhero = new Superhero();
		superhero.setSuperheroId(2);
		superhero.setSuperheroName("Mystique");
		superhero.setSuperheroDescription("A mutant shape-shifter with the ability to change her appearance");
		superhero.setSuperheroSuperpower("ShapeShifting");

		int result = superheroDao.addSuperhero(superhero);

		assertEquals(1, result);
	}

	// ADD superhero - negative scenario (Id already exists) - Test02
	@Test
	public void addSuperHeroTest02() {
		Superhero superhero = new Superhero();
		superhero.setSuperheroId(1);
		superhero.setSuperheroName("Mystique");
		superhero.setSuperheroDescription("A mutant shape-shifter with the ability to change her appearance");
		superhero.setSuperheroSuperpower("ShapeShifting");

		assertThrows(DataAccessException.class, () -> {
			superheroDao.addSuperhero(superhero);
		});
	}

	// GET superhero by existing ID - Test01
	@Test
	public void getSuperheroByIdTest01() {

		int superheroId = 1;

		Superhero superhero = superheroDao.getSuperheroById(superheroId);

		System.out.println(superhero);
		assertEquals(superheroId, superhero.getSuperheroId());
	}

	// GET superhero by ID - negative scenario (Id does not exist)
	@Test
	public void getSuperheroByIdTest02() {

		int superheroId = 222;

		Superhero superhero = superheroDao.getSuperheroById(superheroId);

		System.out.println(superhero);
		assertNull(superhero);
	}

	// GET all Superheroes
	@Test
	public void getAllSuperheros01() {

		List<Superhero> expectedSuperheroes = new ArrayList<>();
		expectedSuperheroes.add(new Superhero(1, "Wonder Woman",
				"Princess Diana of Themyscira, a powerful Amazon warrior with enhanced strength, agility, and combat skills. She fights for justice, peace, and gender equality.",
				"Enhanced strength, speed, agility, and durability."));
		expectedSuperheroes.add(new Superhero(2, "Captain Marvel",
				"Carol Danvers, a former U.S. Air Force pilot who gained superhuman abilities after being exposed to alien technology. She is a skilled fighter and protector of Earth.",
				"Super strength, energy projection, flight, and invulnerability."));
		expectedSuperheroes.add(new Superhero(3, "Black Widow",
				"Natasha Romanoff, a highly skilled spy, and assassin. She is a master in hand-to-hand combat and covert operations.",
				"Exceptional martial arts skills, espionage expertise, and enhanced physical abilities."));
		expectedSuperheroes.add(new Superhero(4, "Storm",
				"Ororo Munroe, a mutant with the ability to manipulate weather. She is a member of the X-Men and a natural leader.",
				"Weather manipulation, including control over lightning, wind, and precipitation."));
		expectedSuperheroes.add(new Superhero(5, "Supergirl",
				"Kara Zor-El, the cousin of Superman, possesses similar superhuman abilities. She protects Earth from various threats alongside her cousin.",
				"Super strength, flight, invulnerability, and heat vision."));
		expectedSuperheroes.add(new Superhero(6, "Gamora",
				"A highly skilled assassin and member of the Guardians of the Galaxy. She seeks redemption for her past actions.",
				"Enhanced strength, agility, and expert swordsmanship."));
		expectedSuperheroes.add(new Superhero(7, "Jessica Jones",
				"A former superhero who now works as a private investigator. She possesses superhuman strength and a no-nonsense attitude.",
				"Super strength and enhanced durability."));
		expectedSuperheroes.add(new Superhero(8, "Batwoman",
				"Kate Kane, a highly skilled detective and martial artist who operates in Gotham City. She fights crime using her intellect, combat skills, and advanced technology.",
				"Exceptional combat skills, detective abilities, and advanced gadgets."));
		expectedSuperheroes.add(new Superhero(9, "Valkyrie",
				"A fierce Asgardian warrior and member of Thor's team. She wields a magical sword and is skilled in combat and leadership.",
				"Enhanced strength, agility, and swordsmanship."));
		expectedSuperheroes.add(new Superhero(10, "Rogue",
				"Anna Marie, a mutant with the ability to absorb the memories, powers, and life force of others through touch. She is a member of the X-Men.",
				"HeroSuperpower: Power absorption and flight."));
		expectedSuperheroes.add(new Superhero(11, "Hawkgirl",
				"Kendra Saunders, a reincarnated warrior from ancient Egypt. She possesses wings, enhanced strength, and a mace, and fights alongside other superheroes.",
				"Flight, enhanced strength, and combat skills."));
		expectedSuperheroes.add(new Superhero(12, "Scarlet Witch",
				"Wanda Maximoff, a mutant with reality-altering powers. She can manipulate energy, probability, and minds.",
				"Reality manipulation, energy projection, and telekinesis."));
		expectedSuperheroes.add(new Superhero(13, "Batgirl",
				"Barbara Gordon, the daughter of Gotham City's Police Commissioner. She operates as a skilled detective and vigilante to protect her city.",
				"Exceptional martial arts skills, detective abilities, and technological expertise."));

		List<Superhero> actualSuperheroes = superheroDao.getAllSuperheroes();

		assertEquals(expectedSuperheroes.size(), actualSuperheroes.size());

	}

}

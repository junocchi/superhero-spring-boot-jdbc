package com.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import com.dto.entity.Location;
import com.dto.entity.Sighting;

import com.dto.entity.Organisation;
import com.model.persistence.*;

@ActiveProfiles("test")
@SpringBootTest
class LocationDaoTests {

	@Autowired
	private LocationDao dao;
	@Autowired
	private SightingDao dao2;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	@DisplayName("Test for getting all Locations")
	public void ReturnAllLocationTests01() {
		List<Location> locationsList = dao.getAllLocations();
		assertEquals(10, locationsList.size());

	}

	@Test
	@DisplayName("Test for checking if Locations have been inserted correctly")
	public void ReturnAllLocationTests02() {
		List<Location> locationsList = dao.getAllLocations();
		assertEquals("Hero Headquarters", locationsList.get(0).getLocationName());
	}

	@Test
	@DisplayName("Test for checking if the correct Location is being selected")
	public void GetLocationByID01() {
		Location location = dao.getLocationById(1);
		assertEquals("Hero Headquarters", location.getLocationName());
	}

	@Test
	@DisplayName("Test for invalid location")
	public void GetLocationByID02() {
		Location location = dao.getLocationById(99);
		assertNull(location, "Location not found");
	}

	@Test
	@DisplayName("Test if Location is added sucessfully")
	public void AddLocation01() {
		Location location = new Location();
		List<Sighting> heroSight = new ArrayList<Sighting>();

		heroSight.add(dao2.getSightingById(1));
		heroSight.add(dao2.getSightingById(5));

		location.setLocationId(11); // This id should not exist in the database
		location.setLocationName("HighField SuperMarket");
		location.setLocationDescription(
				"A valued SuperMarket that serves the city, busy till the late hours of the night");
		location.setAddress("106 GreatVille Road");
		location.setCoordinates("39.9336° S, 75.5352° W");
		location.setSightingList(heroSight);

		int result = dao.addLocation(location);

		assertEquals(1, result);
		assertNotNull(dao.getLocationById(11));
	}

	@Test
	@DisplayName("Test if Location is not added sucessfully (due to duplicate keys)")
	public void AddLocation02() {
		Location location = new Location();
		List<Sighting> heroSight = new ArrayList<Sighting>();

		heroSight.add(dao2.getSightingById(1));
		heroSight.add(dao2.getSightingById(5));

		location.setLocationId(1); // This id should not exist in the database
		location.setLocationName("HighField SuperMarket");
		location.setLocationDescription(
				"A valued SuperMarket that serves the city, busy till the late hours of the night");
		location.setAddress("106 GreatVille Road");
		location.setCoordinates("39.9336° S, 75.5352° W");
		location.setSightingList(heroSight);

		int result = dao.addLocation(location);

		assertEquals(0, result);
	}

	@Test
	@DisplayName("Test if Location has been deleted")
	public void DeleteLocation01() {

		int delete = dao.deleteLocation(5);

		assertEquals(1, delete);
	}

	@Test
	@DisplayName("Test if Location has not been deleted (Location not valid)")
	public void DeleteLocation02() {

		int delete = dao.deleteLocation(99);

		assertEquals(0, delete);
	}

	@Test
	@DisplayName("Test if Location's description has been update")
	public void updateLocation01() {

		int update = dao.updateLocation(2, "I absolutely hate this place! I fell over and scrapped my knee");

		assertEquals(1, update);
	}

	@Test
	@DisplayName("Test if Location's description has not been update")
	public void updateLocation02() {

		int update = dao.updateLocation(99, "I absolutely hate this place! I fell over and scrapped my knee");

		assertEquals(0, update);
	}

	@AfterEach
	public void tearDown() {
		dao.deleteLocation(11);
	}

}

package com.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.dto.entity.Sighting;
import com.model.persistence.SightingDao;


@ActiveProfiles("test")
@SpringBootTest
@DisplayName(value = "Test Sighting Dao Layer")
class SightingDaoTests {
	@Autowired
	private SightingDao sightingDao;
	
//	@AfterEach
//	 public void tearDown() {
//	  // Reset or clean up any data that was saved during the test
//	  // This ensures that the database is not affected by the tests
//	 }

	@AfterEach
	public void afterAll() {
	}
	
	@Nested
	@DisplayName(value = "Add a New Sighting")
    class addSightingTest {
		
        @Test
        @DisplayName(value = "New Sighting Is Correct")
        void addSightingTest01() {
        	Sighting sighting = new Sighting();
        	
        	sighting.setSightingId(11);
        	sighting.setSuperheroId(1);
        	sighting.setLocationId(1);
        	sighting.setSightingDate(new Date(0));
        	
        	Sighting addedSighting = sightingDao.addSighting(sighting);
        	assertNotNull(addedSighting);
        	assertNotNull(sightingDao.getSightingById(addedSighting.getSightingId()));
        	assertEquals(sightingDao.getAllSighting().size(), 11);
        	
        	sightingDao.deleteSighting(addedSighting.getSightingId());
        }
        
        @Test
        @DisplayName(value = "Missing Foreign Key")
        void addSightingTest02() {
        	Sighting sighting = new Sighting();
        	
        	sighting.setSightingId(10);
        	sighting.setSuperheroId(99);
        	sighting.setLocationId(99);
        	sighting.setSightingDate(new Date(0));
        	
        	Sighting addedSighting = sightingDao.addSighting(sighting);
 
        	assertNull(addedSighting);
        	assertEquals(sightingDao.getAllSighting().size(), 10);
        }
    }
	
	@Nested
	@DisplayName(value = "Get Sighting By ID")
    class getSightingByIdTest{
        @Test
        @DisplayName(value = "ID Exists")
        void getSightingByIdTest01() {
        	Sighting sighting = sightingDao.getSightingById(1);
        	assertNotNull(sighting);
        }
        
        @Test
        @DisplayName(value = "ID Doesn't Exist")
        void getSightingByIdTest02() {
        	Sighting sighting = sightingDao.getSightingById(99);
        	assertNull(sighting);
        }
    }
	
	@Nested
	@DisplayName(value = "Get All Sightings")
    class getAllSightingTest{
        @Test
        @DisplayName(value = "Check List Size")
        void getAllSightingTest01() {
        	List<Sighting> sightingList = sightingDao.getAllSighting();
        	assertEquals(sightingList.size(), 10);
        }
    }
	
	@Nested
	@DisplayName(value = "Delete Sighting By ID")
    class deleteSightingTest{
        @Test
        @DisplayName(value = "ID Exists")
        void deleteSightingTest01() {
        	Sighting sighting = new Sighting();
        	
        	sighting.setSightingId(11);
        	sighting.setSuperheroId(2);
        	sighting.setLocationId(1);
        	sighting.setSightingDate(new Date(0));
        	
        	Sighting addedSighting = sightingDao.addSighting(sighting);
        	
        	assertEquals(sightingDao.getAllSighting().size(), 11);
        	assertTrue(sightingDao.deleteSighting(addedSighting.getSightingId()));
        	assertEquals(sightingDao.getAllSighting().size(), 10);
        	assertNull(sightingDao.getSightingById(addedSighting.getSightingId()));
        }
        
        @Test
        @DisplayName(value = "ID Doesn't Exist")
        void deleteSightingTest02() {
        	assertEquals(sightingDao.getAllSighting().size(), 10);
        	assertFalse(sightingDao.deleteSighting(99));
        	assertEquals(sightingDao.getAllSighting().size(), 10);
        }
    }
	
	@Nested
	@DisplayName(value = "Update Sighting Fields")
    class updateSightingTest{
        @Test
        @DisplayName(value = "ID Exists")
        void updateSightingTest01() {
        	Sighting oldSighting = sightingDao.getSightingById(1);
        	Sighting newSighting = new Sighting();
        	
        	newSighting.setSightingId(oldSighting.getSightingId());
        	newSighting.setSuperheroId(2);
        	newSighting.setLocationId(2);
        	newSighting.setSightingDate(oldSighting.getSightingDate());
        	
        	assertTrue(sightingDao.updateSighting(newSighting));
        	System.out.println(newSighting);
        	System.out.println(sightingDao.getSightingById(1));
        	assertTrue(newSighting.equals(sightingDao.getSightingById(1)));
        	assertEquals(sightingDao.getAllSighting().size(), 10);
        }
        
        @Test
        @DisplayName(value = "ID Doesn't Exist")
        void updateSightingTest02() {
        	Sighting newSighting = new Sighting();
        	
        	newSighting.setSightingId(99);
        	newSighting.setSuperheroId(2);
        	newSighting.setLocationId(2);
        	newSighting.setSightingDate(new Date(0));
        	
        	assertFalse(sightingDao.updateSighting(newSighting));
        	assertNull(sightingDao.getSightingById(99));
        	assertEquals(sightingDao.getAllSighting().size(), 10);
        }
    }

}

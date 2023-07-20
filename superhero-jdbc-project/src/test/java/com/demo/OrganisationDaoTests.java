package com.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ActiveProfiles;

import com.dto.entity.Organisation;
import com.model.persistence.OrganisationDao;

@ActiveProfiles("test")
@SpringBootTest
class OrganisationDaoTests {

	@Autowired
	private OrganisationDao organisationDao;
/*
	@AfterEach
	public void tearDown() {
		organisationDao.deleteOrganisation(226);
	}
*/
	
	@Test
	public void updateOrganisation01() {
	    
		Organisation organisation = new Organisation();
	    organisation.setOrganisationId(101); // ID must exist in database
	    organisation.setOrgName("New Avengers"); 
	    organisation.setOrgDescription("A reformed team of superheroes assembled to protect the world from new threats."); // Updated organization description
	    organisation.setOrgInfo("456 New Avengers Tower, New York, USA"); 
	    
	    
	    int result = organisationDao.updateOrganisation(organisation);
	    
	    
	    assertEquals(1, result); 
	}

	@Test
	public void updateOrganisation02() {
	    
		Organisation organisation = new Organisation();
	    organisation.setOrganisationId(378); // Assuming this ID does not exist in the database
	    organisation.setOrgName("New Organisation"); 
	    organisation.setOrgDescription("A test organization"); 
	    organisation.setOrgInfo("Test info"); 
	    
	    
	    int result = organisationDao.updateOrganisation(organisation);
	    
	    
	    assertEquals(0, result); 
	}
	
	@Test
	public void deleteOrganisation01() {

		int organisationId = 105; // Assuming this ID exists in the database

		int result = organisationDao.deleteOrganisation(organisationId);

		assertEquals(1, result);
	}

	@Test
	public void deleteOrganisation02() {

		int organisationId = 990; // Assuming this ID does not exist in the database

		int result = organisationDao.deleteOrganisation(organisationId);

		assertEquals(0, result); //
	}

	@Test
	public void addOrganisationTest01() {
		Organisation organisation = new Organisation();
		organisation.setOrganisationId(105); // This id should not exist in the database
		organisation.setOrgName("Hero Central Park");
		organisation.setOrgDescription("A sprawling park with training grounds and secret entrances.");
		organisation.setOrgInfo("101 Avenue Road");

		int result = organisationDao.addOrganisation(organisation);

		assertEquals(1, result);

	}

	@Test
	public void addOrganisationTest02() {
		Organisation organisation = new Organisation();
		organisation.setOrganisationId(101); // Assuming ID already exists in the database
		organisation.setOrgName("Marvel");
		organisation.setOrgDescription("A sprawling park with training grounds and secret entrances.");
		organisation.setOrgInfo("332 London Road");

		assertThrows(DataAccessException.class, () -> {
			organisationDao.addOrganisation(organisation);
		});
	}

	@Test
	public void getOrganisationByIdTest01() {

		int organisationId = 101; // Should already exist in database

		Organisation organisation = organisationDao.getOrganisationById(organisationId);

		assertNotNull(organisation);
		assertEquals(organisationId, organisation.getOrganisationId());
	}

	@Test
	public void getOrganisationByIdTest02() {

		// This id should not exist in the database
		int organisationId = 378;

		Organisation organisation = organisationDao.getOrganisationById(organisationId);

		assertNull(organisation);
	}

	@Test
	public void getAllOrganisations01() {

		List<Organisation> expectedOrganisations = new ArrayList<>();
		expectedOrganisations.add(
				new Organisation(101, "Avengers", "A team of superheroes assembled to protect the world from threats.",
						"123 Avengers Tower, New York, USA"));
		expectedOrganisations.add(new Organisation(102, "Justice League",
				"A group of powerful heroes who work together to fight crime and maintain peace.",
				"456 Hall of Justice, Metropolis, USA"));
		expectedOrganisations.add(new Organisation(103, "X-Men",
				"A team of mutants with extraordinary powers fighting for a world that fears and hates them.",
				"789 Xavier's School for Gifted Youngsters, Salem Center, USA"));
		expectedOrganisations.add(new Organisation(104, "Fantastic Four",
				"A team of scientific explorers who gained superhuman abilities after exposure to cosmic rays.",
				"101 Baxter Building, New York, USA"));
		//expectedOrganisations.add(new Organisation(105, "Guardians of the Galaxy",
				//"A group of intergalactic heroes protecting the universe from various threats.",
				//"999 Knowhere, Outer Space"));
		expectedOrganisations.add(new Organisation(106, "S.H.I.E.L.D.",
				"A covert international agency dedicated to protecting the world.",
				"555 S.H.I.E.L.D. Helicarrier, International Waters"));
		expectedOrganisations.add(new Organisation(107, "League of Assassins",
				"A secret society of highly skilled assassins with their own agenda.",
				"777 League Headquarters, Unknown Location"));
		expectedOrganisations.add(new Organisation(108, "Independent (Alias Investigations)",
				"Private investigation agency run by Jessica Jones.", "42nd Street, New York, USA"));
		expectedOrganisations.add(new Organisation(109, "Independent (Gotham City)",
				"Independent crime-fighting organization operating in Gotham City.",
				"123 Crime Alley, Gotham City, USA"));

		List<Organisation> actualOrganisations = organisationDao.getAllOrganisations();

		assertEquals(expectedOrganisations.size(), actualOrganisations.size());

	}

}

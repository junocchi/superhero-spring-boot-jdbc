package com.model.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dto.entity.Sighting;

@Repository
public class SightingDaoImpl implements SightingDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Sighting addSighting(Sighting sighting) {
		try {
			String query = "INSERT INTO sighting (SuperheroId, LocationId, SightingDate) VALUES (?,?,?);";
			jdbcTemplate.update(query, sighting.getSuperheroId(), sighting.getLocationId(), sighting.getSightingDate());
			
			query = "SELECT * FROM sighting WHERE sightingid = (SELECT MAX(sightingid) FROM sighting);";
			return jdbcTemplate.query(query, new SightingMapper()).get(0);
		} catch (DataIntegrityViolationException ex) {
			return null;
		} catch (IndexOutOfBoundsException ex) {
			return null;
		}
	}

	@Override
	public Sighting getSightingById(int id) {
		String query = "SELECT * FROM sighting WHERE sightingid = ?;";
		try {
			return jdbcTemplate.query(query, new SightingMapper(), id).get(0);
		} catch (IndexOutOfBoundsException ex) {
			return null;
		}
	}

	@Override
	public List<Sighting> getAllSighting() {
		String query = "SELECT * FROM sighting";
		return jdbcTemplate.query(query, new SightingMapper());
	}

	@Override
	public boolean deleteSighting(int id) {
		String query = "DELETE FROM sighting WHERE SightingId = ?";
		return jdbcTemplate.update(query, id) > 0;
	}

	@Override
	public boolean updateSighting(Sighting sighting) {
		String query = "UPDATE sighting SET SuperheroId = ?, LocationId = ?, SightingDate = ? WHERE SightingId = ?";
		return jdbcTemplate.update(query, sighting.getSuperheroId(), sighting.getLocationId(), sighting.getSightingDate(),
				sighting.getSightingId()) > 0;
	}
	
	public List<Sighting> getLatestSightings() {
		String query = "SELECT * FROM Sighting ORDER BY SightingDate DESC LIMIT 10";
		return jdbcTemplate.query(query, new SightingMapper());
	}

}

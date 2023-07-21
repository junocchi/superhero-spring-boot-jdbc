package com.model.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dto.entity.Location;

@Repository
public class LocationDaoImpl implements LocationDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override

	public List<Location> getAllLocations() {

		String sql = "SELECT * FROM Location";

		return jdbcTemplate.query(sql, new LocationMapper(jdbcTemplate));
	}

	@Override

	public Location getLocationById(int id) {

		String SQL = "SELECT * FROM Location WHERE LocationId =?";
		try {
			return jdbcTemplate.queryForObject(SQL, new LocationMapper(jdbcTemplate), id);

		} catch (EmptyResultDataAccessException ex) {
			return null;
		}
	}

	@Override

	public int addLocation(Location location) {

		try {

			String query = "INSERT INTO Location VALUES(?,?,?,?,?)";

			return jdbcTemplate.update(query, location.getLocationId(), location.getLocationName(),
					location.getLocationDescription(), location.getAddress(), location.getCoordinates());

		} catch (DuplicateKeyException exception) {

			return 0;
		}

	}

	@Override
	public int deleteLocation(int locationID) {
		try {
			return jdbcTemplate.update("DELETE FROM Location WHERE locationID=?", locationID);
		} catch (Exception ex) {
			return 0;
		}
	}

	@Override
	public int updateLocation(int locationId, String locationDescription) {
		try {
			return jdbcTemplate.update("UPDATE Location SET LocationDescription=? WHERE locationId=?",
					locationDescription, locationId);
		} catch (Exception ex) {
			return 0;
		}
	}
}

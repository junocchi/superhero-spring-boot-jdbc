package com.model.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dto.entity.Location;
import com.dto.entity.Sighting;


public class LocationMapper implements RowMapper <Location> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
   
	

    @Autowired
    public LocationMapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    

		@Override
		public Location mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			int locationId = resultSet.getInt("LOCATIONID");
			String locationName = resultSet.getString("LOCATIONNAME");
			String locationDescription = resultSet.getString("LOCATIONDESCRIPTION");
			String address = resultSet.getString("ADDRESS");
			String coordinates = resultSet.getString("COORDINATES");
			String SQL = "SELECT * FROM sighting  WHERE locationid =?";
			List <Sighting> sightingsList = jdbcTemplate.query(SQL, new SightingMapper(), locationId);
			
			
			

			Location location = new Location(locationId, locationName, locationDescription, address, coordinates,sightingsList);
			return location;
		}
		
		
		
		
		

	}

	



package com.model.persistence;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dto.entity.Sighting;

public class SightingMapper implements RowMapper<Sighting> {

		@Override
		public Sighting mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			int SightingId = resultSet.getInt("SIGHTINGID");
			int heroID = resultSet.getInt("SUPERHEROID");
			int locationID = resultSet.getInt("LOCATIONID");
			Date sightingDate = resultSet.getDate("SIGHTINGDATE");

			Sighting sighting = new Sighting(SightingId, heroID, locationID, sightingDate);
			return sighting;
		}
}

	



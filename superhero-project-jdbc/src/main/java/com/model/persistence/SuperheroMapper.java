package com.model.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dto.entity.Superhero;

public class SuperheroMapper implements RowMapper<Superhero> {
	
	@Override
	public Superhero mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		int superheroId = resultSet.getInt("SUPERHEROID");
		String superheroName = resultSet.getString("SUPERHERONAME");
		String superheroDescription = resultSet.getString("SUPERHERODESCRIPTION");
		String superheroSuperpower = resultSet.getString("SUPERHEROSUPERPOWER");

		Superhero superhero = new Superhero(superheroId, superheroName, superheroDescription, superheroSuperpower);
		return superhero;
	}
}

package com.model.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.dto.entity.Superpower;



public class SuperpowerMapper implements RowMapper <Superpower> {

	
	@Override
	public Superpower mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		int superpowerId = resultSet.getInt("SUPERPOWERID");
		String superpowerName = resultSet.getString("SUPERPOWERNAME");
		int superheroId = resultSet.getInt("SUPERHEROID");
		
		

		Superpower superpower = new Superpower(superpowerId, superpowerName ,superheroId);
		return superpower;
	}
}

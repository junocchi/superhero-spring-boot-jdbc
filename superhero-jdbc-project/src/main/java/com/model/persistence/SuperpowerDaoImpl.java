package com.model.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dto.entity.Organisation;
import com.dto.entity.Superpower;

@Repository
public class SuperpowerDaoImpl implements SuperpowerDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public int addSuperpower(Superpower superpower) {

		String query = "INSERT INTO SUPERPOWER VALUES(?,?,?)";
		return jdbcTemplate.update(query, superpower.getSuperpowerId(), superpower.getSuperpowerName(), superpower.getSuperheroId());

	}
	
	
	@Override
	public Superpower getSuperpowerById(int superpowerId) {
		String query="SELECT * FROM SUPERPOWER WHERE SUPERPOWERID="+ superpowerId;
		try {
		return jdbcTemplate.queryForObject(query, new SuperpowerMapper());
		}
		catch(EmptyResultDataAccessException exception) {
			return null;
		}
	}
	
	@Override
	public List<Superpower> getAllSuperpowers() {
		String query = "SELECT * FROM SUPERPOWER";
		return jdbcTemplate.query(query, new SuperpowerMapper());
	}
	
	
	@Override
	public int deleteSuperpower(int superpowerId) {
		String query = "DELETE FROM SUPERPOWER WHERE SUPERPOWERID = ?";
		return jdbcTemplate.update(query, superpowerId);
	}
	
	@Override
	public int updateSuperpower(Superpower superpower) {
		String query = "UPDATE SUPERPOWER SET SUPERPOWERNAME = ?, SUPERHEROID = ? WHERE SUPERPOWERID = ?";
		return jdbcTemplate.update(query, superpower.getSuperpowerName(), superpower.getSuperheroId(), superpower.getSuperpowerId());
	}
}

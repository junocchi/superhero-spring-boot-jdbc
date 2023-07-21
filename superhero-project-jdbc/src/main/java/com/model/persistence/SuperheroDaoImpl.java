package com.model.persistence;

import com.dto.entity.Superhero;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
// @ComponentScan(basePackages = "com.model.persistence")
public class SuperheroDaoImpl implements SuperheroDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addSuperhero(Superhero superhero) throws DataAccessException {
		String query = "INSERT INTO SUPERHERO VALUES (?,?,?,?)";
		try {
			return jdbcTemplate.update(query, superhero.getSuperheroId(), superhero.getSuperheroName(),
					superhero.getSuperheroDescription(), superhero.getSuperheroSuperpower());
		} catch (DuplicateKeyException e) {
			throw new DataAccessException("Duplicate superhero ID", e) {
			};
		}
	}

	@Override
	public Superhero getSuperheroById(int superheroId) {
		String querySuperheroById = "SELECT * FROM SUPERHERO WHERE SUPERHEROID=" + superheroId;
		try {
			return jdbcTemplate.queryForObject(querySuperheroById, new SuperheroMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}

	@Override
	public List<Superhero> getAllSuperheroes() {
		String queryAllSuperheroes = "SELECT * FROM SUPERHERO";
		return jdbcTemplate.query(queryAllSuperheroes, new SuperheroMapper());
	}

	@Override
	public boolean deleteSuperheroById(int superheroId) {
		String query = "DELETE FROM SUPERHERO WHERE SUPERHEROID = ?";
		return jdbcTemplate.update(query, superheroId) > 0;
	}

	@Override
	public boolean updateSuperhero(Superhero superhero) {
		String query = "UPDATE Superhero SET SuperheroName = ?, SuperheroDescription = ?, SuperheroSuperpower = ? WHERE superheroId = ?";
		return jdbcTemplate.update(query, superhero.getSuperheroName(), superhero.getSuperheroDescription(),
				superhero.getSuperheroSuperpower(), superhero.getSuperheroId()) > 0;
	}

}

package com.model.persistence;

import java.util.List;

import com.dto.entity.Superhero;

public interface SuperheroDao {

	public int addSuperhero(Superhero superhero);

	public Superhero getSuperheroById(int superheroId);

	public List<Superhero> getAllSuperheroes();

	public boolean deleteSuperheroById(int superheroId);

	//public int updateSuperhero(int superheroId, String superheroDescription);

	public boolean updateSuperhero(Superhero superhero);
}

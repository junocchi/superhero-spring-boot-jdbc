package com.model.service;

import java.util.List;

import com.dto.entity.Superhero;

public interface SuperheroService {
	public int addSuperhero(Superhero superhero);

	public boolean deleteSuperhero(int id);

	public List<Superhero> getAllSuperheroes();

	public Superhero getSuperheroById(int id);

	public boolean updateSuperhero(Superhero superhero);
}

package com.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.entity.Superhero;
import com.model.persistence.SuperheroDao;

@Service
public class SuperheroServiceImp implements SuperheroService {
	@Autowired
	private SuperheroDao superheroDao;

	@Override
	public Superhero getSuperheroById(int id) {
		return superheroDao.getSuperheroById(id);
	}

	@Override
	public int addSuperhero(Superhero superhero) {
		return superheroDao.addSuperhero(superhero);
	}

	@Override
	public boolean deleteSuperhero(int id) {
		return superheroDao.deleteSuperheroById(id);
	}

	@Override
	public List<Superhero> getAllSuperheroes() {
		return superheroDao.getAllSuperheroes();
	}

	@Override
	public boolean updateSuperhero(Superhero superhero) {
		return superheroDao.updateSuperhero(superhero);
	}

}

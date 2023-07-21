package com.model.persistence;

import java.util.List;

import com.dto.entity.Sighting;

public interface SightingDao {
	public Sighting addSighting(Sighting sighting);
	public Sighting getSightingById(int id);
	public List<Sighting> getAllSighting();
	public boolean deleteSighting(int id);
	public boolean updateSighting(Sighting sighting);
}

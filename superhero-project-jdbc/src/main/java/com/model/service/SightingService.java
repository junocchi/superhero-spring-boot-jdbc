package com.model.service;

import java.util.List;

import com.dto.entity.Sighting;
import com.dto.entity.SightingText;

public interface SightingService {
	public Sighting addSighting(Sighting sighting);
	public Sighting getSightingById(int id);
	public List<Sighting> getAllSighting();
	public boolean deleteSighting(int id);
	public boolean updateSighting(Sighting sighting);
	public List<SightingText> getLatestSightings();
}

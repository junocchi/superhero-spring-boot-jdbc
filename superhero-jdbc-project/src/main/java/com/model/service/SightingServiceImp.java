package com.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.entity.Sighting;
import com.dto.entity.SightingText;
import com.model.persistence.SightingDaoImpl;

@Service
public class SightingServiceImp implements SightingService{
	@Autowired
	private SightingDaoImpl dao;
	@Autowired
	private LocationServiceImp locationService;
	@Autowired
	private SuperheroService superheroService;

	@Override
	public Sighting addSighting(Sighting sighting) { 
		return dao.addSighting(sighting);
	}

	@Override
	public Sighting getSightingById(int id) {
		return dao.getSightingById(id);
	}

	@Override
	public List<Sighting> getAllSighting() {
		return dao.getAllSighting();
	}

	@Override
	public boolean deleteSighting(int id) {
		return dao.deleteSighting(id);
	}

	@Override
	public boolean updateSighting(Sighting sighting) {
		return dao.updateSighting(sighting);
	}

	@Override
	public List<SightingText> getLatestSightings() {
		List<Sighting> sightingList= dao.getLatestSightings();
		List<SightingText> sightings = new ArrayList<SightingText>();
		
		for(Sighting sighting : sightingList) {
			SightingText sightingToAdd = new SightingText();
			
			sightingToAdd.setSightingId(sighting.getSightingId());
			sightingToAdd.setSuperheroName(superheroService.getSuperheroById(sighting.getSuperheroId()).getSuperheroName());
			sightingToAdd.setLocationName(locationService.getLocationById(sighting.getLocationId()).getLocationName());
			sightingToAdd.setSightingDate(sighting.getSightingDate());
			
			sightings.add(sightingToAdd);
		}
			
		return sightings;
	}

}

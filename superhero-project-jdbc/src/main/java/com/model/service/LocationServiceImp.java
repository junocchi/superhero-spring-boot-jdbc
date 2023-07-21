package com.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.entity.Location;
import com.model.persistence.LocationDao;

@Service
public class LocationServiceImp {

	@Autowired
	LocationDao dao;

	public List<Location> getAllLocations() {

		return dao.getAllLocations();
	}

	public Location getLocationById(int id) {

		return dao.getLocationById(id);
	}

	public int addLocation(Location location) {

		return dao.addLocation(location);
	}

	public int deleteLocation(int locationID) {

		return dao.deleteLocation(locationID);

	}

	public int updateLocation(int locationID, String locationDescription) {

		return dao.updateLocation(locationID, locationDescription);
	}

}

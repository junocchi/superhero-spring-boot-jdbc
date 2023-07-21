package com.model.service;

import java.util.List;

import com.dto.entity.Location;

public interface LocationService {
	
	public List<Location> getAllLocations();

	public Location getLocationById(int id);
	
	public int addLocation(Location location);

	public int deleteLocation(int locationID);

	public int updateLocation(int locationID, String locationDescription);


}

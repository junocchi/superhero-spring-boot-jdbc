package com.model.persistence;

import java.util.List;

import com.dto.entity.Location;

public interface LocationDao {
	
	List<Location> getAllLocations();

	Location getLocationById(int id);
	
	int addLocation(Location location);

	int deleteLocation(int locationID);

	int updateLocation(int locationID, String locationDescription);

}

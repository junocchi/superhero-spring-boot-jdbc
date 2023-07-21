package com.dto.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.relational.core.mapping.MappedCollection;

public class Location {

	private int locationId;
	private String locationName;
	private String locationDescription;
	private String address;
	private String coordinates;
	@MappedCollection
	private List<Sighting> sightingList = new ArrayList<Sighting>();
	
	public Location(int locationId, String locationName, String locationDescription, String address, String coordinates,
			List<Sighting> sightingList) {

		super();
		this.locationId = locationId;
		this.locationName = locationName;
		this.locationDescription = locationDescription;
		this.address = address;
		this.coordinates = coordinates;
		this.sightingList = sightingList;
	}

	public Location() {
		// TODO Auto-generated constructor stub
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationDescription() {
		return locationDescription;
	}

	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	public List<Sighting> getSightingList() {
		return sightingList;
	}

	public void setSightingList(List<Sighting> sightingList) {
		this.sightingList = sightingList;
	}
	
}
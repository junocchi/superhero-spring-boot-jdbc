package com.dto.entity;

import java.sql.Date;
import java.util.Objects;

public class SightingText {
	
	private int sightingId;
	private String superheroName;
	private String locationName;
	private Date sightingDate;
	
	public int getSightingId() {
		return sightingId;
	}
	public void setSightingId(int sightingId) {
		this.sightingId = sightingId;
	}
	public String getSuperheroName() {
		return superheroName;
	}
	public void setSuperheroName(String superheroName) {
		this.superheroName = superheroName;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public Date getSightingDate() {
		return sightingDate;
	}
	public void setSightingDate(Date sightingDate) {
		this.sightingDate = sightingDate;
	}
	public SightingText(int sightingId, String superheroName, String locationName, Date sightingDate) {
		super();
		this.sightingId = sightingId;
		this.superheroName = superheroName;
		this.locationName = locationName;
		this.sightingDate = sightingDate;
	}
	public SightingText() {
		super();
	}
}

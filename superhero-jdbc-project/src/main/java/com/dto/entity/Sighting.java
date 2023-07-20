package com.dto.entity;

import java.sql.Date;
import java.util.Objects;

public class Sighting {
	
	private int sightingId;
	private int superheroId;
	private int locationId;
	private Date sightingDate;

	public Sighting() {
		super();
	}

	public Sighting(int sightingId, int superheroId, int locationId, Date sightingDate) {
		super();
		this.sightingId = sightingId;
		this.superheroId = superheroId;
		this.locationId = locationId;
		this.sightingDate = sightingDate;
	}

	public int getSightingId() {
		return sightingId;
	}

	public void setSightingId(int sightingId) {
		this.sightingId = sightingId;
	}

	public int getSuperheroId() {
		return superheroId;
	}

	public void setSuperheroId(int superheroId) {
		this.superheroId = superheroId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public Date getSightingDate() {
		return sightingDate;
	}

	public void setSightingDate(Date sightingDate) {
		this.sightingDate = sightingDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(locationId, sightingDate, sightingId, superheroId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sighting other = (Sighting) obj;
		return locationId == other.locationId && Objects.equals(sightingDate, other.sightingDate)
				&& sightingId == other.sightingId && superheroId == other.superheroId;
	}

	@Override
	public String toString() {
		return "Sighting [sightingId = " + sightingId + ", superheroId = " + superheroId + ", locationId = " + locationId
				+ ", sightingDate = " + sightingDate + "]";
	}

}

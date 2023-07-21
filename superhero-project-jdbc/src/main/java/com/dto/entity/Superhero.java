package com.dto.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.relational.core.mapping.MappedCollection;

public class Superhero {

	private int superheroId;
	private String superheroName;
	private String superheroDescription;
	private String superheroSuperpower;

	// @ManyToOne
	@MappedCollection
	private List<Organisation> organisationList = new ArrayList<Organisation>();

	public Superhero() {
		super();
	}

	public Superhero(int superheroId, String superheroName, String superheroDescription, String superheroSuperpower) {
		super();
		this.superheroId = superheroId;
		this.superheroName = superheroName;
		this.superheroDescription = superheroDescription;
		this.superheroSuperpower = superheroSuperpower;
	}

	public int getSuperheroId() {
		return superheroId;
	}

	public void setSuperheroId(int superheroId) {
		this.superheroId = superheroId;
	}

	public String getSuperheroName() {
		return superheroName;
	}

	public void setSuperheroName(String superheroName) {
		this.superheroName = superheroName;
	}

	public String getSuperheroDescription() {
		return superheroDescription;
	}

	public void setSuperheroDescription(String superheroDescription) {
		this.superheroDescription = superheroDescription;
	}

	public String getSuperheroSuperpower() {
		return superheroSuperpower;
	}

	public void setSuperheroSuperpower(String superheroSuperpower) {
		this.superheroSuperpower = superheroSuperpower;
	}

	public List<Organisation> getOrganisationList() {
		return organisationList;
	}

	public void setOrganisationList(List<Organisation> organisationList) {
		this.organisationList = organisationList;
	}

	@Override
	public String toString() {
		return "Superhero [superheroId=" + superheroId + ", superheroName=" + superheroName + ", superheroDescription="
				+ superheroDescription + ", superheroSuperpower=" + superheroSuperpower + "]";
	}

}

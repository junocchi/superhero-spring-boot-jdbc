package com.dto.entity;

public class Superpower {
	
	private int superpowerId;
	private String superpowerName;
	private int superheroId;
	
	
	public Superpower(int superpowerId, String superpowerName, int superheroId) {
		super();
		this.superpowerId = superpowerId;
		this.superpowerName = superpowerName;
		this.superheroId = superheroId;
	}


	public Superpower() {
		super();
	}


	public int getSuperpowerId() {
		return superpowerId;
	}


	public void setSuperpowerId(int superpowerId) {
		this.superpowerId = superpowerId;
	}


	public String getSuperpowerName() {
		return superpowerName;
	}


	public void setSuperpowerName(String superpowerName) {
		this.superpowerName = superpowerName;
	}


	public int getSuperheroId() {
		return superheroId;
	}


	public void setSuperheroId(int superheroId) {
		this.superheroId = superheroId;
	}


	@Override
	public String toString() {
		return "Superpower [superpowerId=" + superpowerId + ", superpowerName=" + superpowerName + ", superheroId="
				+ superheroId + "]";
	}
	
}

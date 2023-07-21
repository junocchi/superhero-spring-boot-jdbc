package com.model.service;

import java.util.List;

import com.dto.entity.Superpower;

public interface SuperpowerService {
	public boolean addSuperpower(Superpower superpower);
	public Superpower getSuperpowerById(int id);
	public List<Superpower> getAllSuperpowers();
	public boolean deleteSuperpower(int id);
	public boolean updateSuperpower(Superpower superpower);
}

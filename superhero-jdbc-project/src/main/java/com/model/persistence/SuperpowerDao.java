package com.model.persistence;

import java.util.List;

import com.dto.entity.Superpower;

public interface SuperpowerDao {

	int addSuperpower(Superpower superpower);

	Superpower getSuperpowerById(int superpowerId);

	List<Superpower> getAllSuperpowers();

	int deleteSuperpower(int superpowerId);

	int updateSuperpower(Superpower superpower);

}

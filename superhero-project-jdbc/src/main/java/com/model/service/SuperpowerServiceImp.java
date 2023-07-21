package com.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.entity.Superpower;
import com.model.persistence.SuperpowerDaoImpl;

@Service
public class SuperpowerServiceImp implements SuperpowerService{
	@Autowired
	private SuperpowerDaoImpl dao;

	@Override
	public boolean addSuperpower(Superpower superpower) { 
		return dao.addSuperpower(superpower) > 0;
	}

	@Override
	public Superpower getSuperpowerById(int id) {
		return dao.getSuperpowerById(id);
	}

	@Override
	public List<Superpower> getAllSuperpowers() {
		return dao.getAllSuperpowers();
	}

	@Override
	public boolean deleteSuperpower(int id) {
		return dao.deleteSuperpower(id) > 0;
	}

	@Override
	public boolean updateSuperpower(Superpower superpower) {
		return dao.updateSuperpower(superpower) > 0;
	}
	
}

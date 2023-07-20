package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.entity.Sighting;
import com.dto.entity.Superhero;
import com.dto.entity.Superpower;
import com.model.service.SuperpowerServiceImp;

public class SuperheroSightingController {
	@Autowired
	private SuperpowerServiceImp service;
	
	@RequestMapping("superpowers/input-superpower-id")
	public ModelAndView enterSuperpowerId() {
		return new ModelAndView("superpowers/InputSuperpowerID.html");
	}
	
	@RequestMapping("superpowers/search-superpower")
	public ModelAndView searchSuperpowerById (@RequestParam("id") int id) {
		ModelAndView modelAndView = new ModelAndView();
		Superpower superpower = service.getSuperpowerById(id);
		if (superpower != null) {
			Superpower newSuperpower = new Superpower();
			newSuperpower.setSuperpowerId(id);
			newSuperpower.setSuperheroId(superpower.getSuperheroId());
			newSuperpower.setSuperpowerName(superpower.getSuperpowerName());
			
			modelAndView.addObject("newSuperpower", newSuperpower);
			modelAndView.addObject("superpower", superpower);
			modelAndView.setViewName("superpowers/InputSuperpowerDetailsForUpdate");
		} else {
			modelAndView.addObject("message", "Superpower with ID " + id + " does not exist.");
			modelAndView.setViewName("sightings/Output.html");
		}
		return modelAndView;
	}
	
	@RequestMapping("/superpowers/update-superpower-details")
	public ModelAndView updateSuperpowerDetails(@ModelAttribute("newSuperpower") Superpower newSuperpower) {
		ModelAndView modelAndView = new ModelAndView();
		
		if (service.updateSuperpower(newSuperpower)) {
			modelAndView.addObject("message", "Superpower has been updated.");
			modelAndView.setViewName("sightings/Output.html");
		} else {
			modelAndView.addObject("message", "Superpower could not be updated.");
			modelAndView.setViewName("sightings/Output.html");
		}
		
		return modelAndView;
	}
	
}

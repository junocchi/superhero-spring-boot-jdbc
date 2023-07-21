package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dto.entity.Sighting;
import com.dto.entity.SightingText;
import com.model.service.SightingService;
import com.model.service.SuperheroService;


@RestController
public class SightingController {
	@Autowired
	private SightingService service;

	@RequestMapping("/")
	public ModelAndView getHomePage() {
		ModelAndView modelAndView = new ModelAndView();
		List<SightingText> sightings = service.getLatestSightings();

		modelAndView.addObject("sightingList", sightings);
		modelAndView.setViewName("Home.html");
		return modelAndView;
	}
	
	@RequestMapping("/sightings")
	public ModelAndView getSightingsMenuPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("sightings/SightingsMenu.html");
		return modelAndView;
	}
	
	@RequestMapping("sightings/input-sighting-details")
	public ModelAndView enterSightingDetails() {
		ModelAndView modelAndView=new ModelAndView();
		
		modelAndView.addObject("sighting", new Sighting());
		modelAndView.setViewName("sightings/InputSightingDetails.html");
		return modelAndView;
	}
	
	@RequestMapping("sightings/submit-sighting-details")
	public ModelAndView submitSightingDetails(@ModelAttribute("sighting") Sighting sighting) {
		ModelAndView modelAndView = new ModelAndView();
		
		String message = null;
		if (service.addSighting(sighting) != null)
			message = "Sighting Added";
		else
			message = "Sighting Not Added";

		modelAndView.addObject("message", message);
		modelAndView.setViewName("sightings/Output.html");

		return modelAndView;
	}
	
	@RequestMapping("sightings/display-sightings")
	public ModelAndView getAllSightings() {
		ModelAndView modelAndView = new ModelAndView();
		
		List<Sighting> sightingList = service.getAllSighting();
		
		modelAndView.addObject("sightingList", sightingList);
		modelAndView.setViewName("sightings/DisplayAllSightings.html");
		return modelAndView;
	}
	
	@RequestMapping("sightings/input-sighting-id")
	public ModelAndView enterSightingId() {
		return new ModelAndView("sightings/InputSightingID.html");
	}
	
	@RequestMapping("sightings/search-sighting")
	public ModelAndView searchSightingById (@RequestParam("id") int id) {
		ModelAndView modelAndView = new ModelAndView();
		Sighting sighting = service.getSightingById(id);
		if (sighting != null) {
			Sighting newSighting = new Sighting();
			newSighting.setSightingId(id);
			newSighting.setSuperheroId(sighting.getSuperheroId());
			newSighting.setLocationId(sighting.getLocationId());
			newSighting.setSightingDate(sighting.getSightingDate());
			
			modelAndView.addObject("newSighting", newSighting);
			modelAndView.addObject("sighting", sighting);
			modelAndView.setViewName("sightings/InputSightingDetailsForUpdate");
		} else {
			modelAndView.addObject("message", "Sighting with ID " + id + " does not exist.");
			modelAndView.setViewName("sightings/Output.html");
		}
		return modelAndView;
	}
	
	@RequestMapping("/sightings/update-sighting-details")
	public ModelAndView updateSightingDetails(@ModelAttribute("newSighting") Sighting newSighting) {
		ModelAndView modelAndView = new ModelAndView();
		
		if (service.updateSighting(newSighting)) {
			modelAndView.addObject("message", "Sighting has been updated.");
			modelAndView.setViewName("sightings/Output.html");
		} else {
			modelAndView.addObject("message", "Sighting could not be updated.");
			modelAndView.setViewName("sightings/Output.html");
		}
		
		return modelAndView;
	}
  
	@RequestMapping("sightings/id-delete-sighting")
	public ModelAndView inputSightingId() {
		return new ModelAndView("sightings/InputSightingIDForDelete");
	}
	
	@RequestMapping("sightings/delete-sighting")
	public ModelAndView deleteSighting(@RequestParam("sightingId") int id) {
		ModelAndView modelAndView = new ModelAndView();
		if (service.deleteSighting(id)) {
			modelAndView.addObject("message", "Sighting has been deleted.");
			modelAndView.setViewName("sightings/Output");
		} else {
			modelAndView.addObject("message", "Sighting with ID " + id + " does not exist.");
			modelAndView.setViewName("sightings/Output");

		}
		return modelAndView;
	}

}













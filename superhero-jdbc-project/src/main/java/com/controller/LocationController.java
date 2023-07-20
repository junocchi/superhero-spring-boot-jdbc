package com.controller;

import java.util.List;
import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dto.entity.Location;
import com.model.service.*;



@RestController
public class LocationController {
	
	@Autowired
	private LocationServiceImp service;

	

	@RequestMapping("/Home")
	public ModelAndView HomePageController() {
		return new ModelAndView("/Home");
	}


	@RequestMapping("/location/LocationMenu")
	public ModelAndView LocationMenuController() {
		return new ModelAndView("/location/LocationMenu");
	}

	@RequestMapping("/location/InputLocationID")
	public ModelAndView InputLocationIdPageController() {
		return new ModelAndView("/location/InputLocationID");
	}

	@RequestMapping("/location/searchLocationById")
	public ModelAndView searchLocationByIdController(@RequestParam("locationId") int id) {
		ModelAndView modelAndView = new ModelAndView();
		Location location = service.getLocationById(id);
		if (location != null) {
			modelAndView.addObject("Location", location);
			modelAndView.setViewName("/location/ShowLocation");
		} else {
			modelAndView.addObject("message", "Location with ID " + id + " does not exist");
			modelAndView.setViewName("/location/Output");

		}

		return modelAndView;
		
		
		
	}	
	

	
	
	
	@RequestMapping("/location/InputLocationDetails")
	public ModelAndView InputLocationDetailsPageController() {
		ModelAndView modelAndView=new ModelAndView();
		
		modelAndView.addObject("location", new Location());
		modelAndView.setViewName("location/InputLocationDetails");
		return modelAndView;
		
	}
	

	@RequestMapping("/location/DisplayAllLocations")
	public ModelAndView showAllLocationsController() {
		ModelAndView modelAndView = new ModelAndView();

		List<Location> locationList = service.getAllLocations();
		modelAndView.addObject("locationList", locationList);
		modelAndView.setViewName("/location/DisplayAllLocations");
		return modelAndView;
	}

	@RequestMapping("/location/saveLocation")
	public ModelAndView saveLocationController(@ModelAttribute("location") Location location) {
		ModelAndView modelAndView = new ModelAndView();
	
	
		String message = null;
		if (service.addLocation(location) == 1)
			message = "Location Added";
		else
			message = "Location Not Added";

		modelAndView.addObject("message", message);
		modelAndView.setViewName("/location/Output");

		return modelAndView;
	}

	@RequestMapping("/location/InputLocationIDForDelete")
	public ModelAndView inputLocationIdPageForDeleteController() {
		return new ModelAndView("/location/InputLocationIDForDelete");
	}

	@RequestMapping("/location/deleteLocation")
	public ModelAndView deleteLocationController(@RequestParam("locationId") int id) {
		ModelAndView modelAndView = new ModelAndView();
		String message = null;
		if (service.deleteLocation(id) == 1) {
			message = "Location with id " + id + " deleted !";
		} else {
			message = "Location with id " + id + " not deleted !";
		}
		modelAndView.addObject("message", message);
		modelAndView.setViewName("/location/Output");
		
		return modelAndView;
	}
	
	@RequestMapping("/location/InputLocationDetailsForUpdate")
	public ModelAndView InputLocationDetailsPageForUpdateController(){
		return new ModelAndView("/location/InputLocationDetailsForUpdate");
	}
	
	
	@RequestMapping("/location/updateLocationDescription")
	public ModelAndView updateLocationDescriptionController(@RequestParam("locationId") int locationId,@RequestParam("description") String description) {
		
		String message=null;
		
		if(service.updateLocation(locationId, description) == 1)
			message="Description Updated for Location ID "+locationId;
		else
			message="Description has failed to update for location: "+locationId;
		
		return new ModelAndView("/location/Output", "message", message);
	}
}
	
	
	
	
	
	
	
	
	
	
	






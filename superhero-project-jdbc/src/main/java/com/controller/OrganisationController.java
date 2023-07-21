
package com.controller;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.entity.SightingText;
import com.model.service.OrganisationService;
import com.dto.entity.*;

@Controller
public class OrganisationController {

	
	
	@Autowired
	private OrganisationService organisationService;
	

	
	@RequestMapping("/organisations")
	public ModelAndView organisationHomepageController() {
		return new ModelAndView("Organisations/OrganisationsMenu");
	}
	
	@RequestMapping("/InputOrganisationDetails")
	public ModelAndView InputOrganisationDetailsPageController() {
		ModelAndView modelAndView=new ModelAndView();
		
		modelAndView.addObject("org", new Organisation());
		modelAndView.setViewName("Organisations/InputOrganisationDetails");
		return modelAndView;	
	}
	
	
	@RequestMapping("/saveorganisation")
	public ModelAndView saveOrganisationController(@ModelAttribute("org") Organisation organisation) {
		ModelAndView modelAndView = new ModelAndView();
	
		String message = null;
		if (organisationService.addOrganisation(organisation))
			message = "Organisation Added";
		else
			message = "Organisation Not Added";

		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");

		return modelAndView;
	}
	
	@RequestMapping("/showAllOrganisations")
	public ModelAndView showAllOrganisationssController() {
		ModelAndView modelAndView = new ModelAndView();

		List<Organisation> orgList = organisationService.getAllOrganisation();
		modelAndView.addObject("organisationList", orgList);
		modelAndView.setViewName("Organisations/DisplayAllOrganisations");
		return modelAndView;
	}
	
	@RequestMapping("/InputOrgDetailsPageForUpdate")
	public ModelAndView InputLocationDetailsPageForUpdateController(){
		return new ModelAndView("Organisations/InputOrgDetailsForUpdate");
	}
	
	
	
	@RequestMapping("/updateOrgDetails")
	public ModelAndView updateOrgDetailsController(@ModelAttribute("org") Organisation organisation) {
	    ModelAndView modelAndView = new ModelAndView();

	    String message = null;
	    if (organisationService.updateOrganisation(organisation))
	        message = "Organisation details updated";
	    else
	        message = "Failed to update organisation details";

	    modelAndView.addObject("message", message);
	    modelAndView.setViewName("Output");

	    return modelAndView;
	}

	
	
	
	@RequestMapping("/InputOrgIdPageForDelete")
	public ModelAndView inputLocationIdPageForDeleteController() {
		return new ModelAndView("/Organisations/InputOrgIdForDelete");
	}

	@RequestMapping("/deleteOrg")
	public ModelAndView deleteLocationController(@RequestParam("organisationId") int organisationId) {
		ModelAndView modelAndView = new ModelAndView();
		String message = null;
		if (organisationService.deleteOrganisation(organisationId) == 1) {
			message = "Organisation with id " + organisationId + " deleted !";
		} else {
			message = "Organisation with id " + organisationId + " not deleted !";
		}
		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");
		
		return modelAndView;
	}
}


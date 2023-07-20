package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.entity.Organisation;
import com.dto.entity.Superpower;
import com.model.service.OrganisationService;
import com.model.service.SuperpowerService;

@Controller
public class SuperpowerController {

	@Autowired
	private SuperpowerService superpowerService;

	@RequestMapping("/superpowers")
	public ModelAndView superpowersHomepageController() {
		return new ModelAndView("superpowers/SuperpowersMenu");
	}

	@RequestMapping("superpowers/input-superpowers-details")
	public ModelAndView InputSuperpowerDetailsPageController() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("power", new Superpower());
		modelAndView.setViewName("superpowers/InputSuperpowerDetails");
		return modelAndView;
	}

	@RequestMapping("superpowers/save-superpower")
	public ModelAndView saveSuperpowerController(@ModelAttribute("power") Superpower superpower) {
		ModelAndView modelAndView = new ModelAndView();

		String message = null;
		if (superpowerService.addSuperpower(superpower))
			message = "Superpower Added";
		else
			message = "Superpower Not Added";

		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");

		return modelAndView;
	}

	// form to search a superpower by id and then delete it
	@RequestMapping("/superpowers/input-superpower-id-for-delete")
	public ModelAndView inputSuperheroIdForDeleteController() {
		return new ModelAndView("/superpowers/InputSuperheroIdForDelete.html");
	}

	@RequestMapping("/delete-superpower-by-id")
	public ModelAndView deleteSuperpowerController(@RequestParam("superpowerId") int superpowerId) {
		ModelAndView modelAndView = new ModelAndView();
		//System.out.println("Testing delete method.");
		if (superpowerService.deleteSuperpower(superpowerId)) {
			modelAndView.addObject("message", "Superpower with ID " + superpowerId + " was deleted!");
			modelAndView.setViewName("superpowers/Output");
		} else {
			modelAndView.addObject("message", "Superpower with ID " + superpowerId + " was not deleted!");
			modelAndView.setViewName("superpowers/Output");
		}
		return modelAndView;
	}
}

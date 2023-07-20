package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dto.entity.Sighting;
import com.dto.entity.Superhero;
import com.model.service.SuperheroService;

@RestController
public class SuperheroController {

	@Autowired
	private SuperheroService superheroService;

	@RequestMapping("/superheroes")
	public ModelAndView welcomePageController() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("superheroes/SuperheroesMenu.html");
		return modelAndView;
	}

	// form to add the superhero
	@RequestMapping("superheroes/input-superhero-details")
	public ModelAndView enterSuperheroDetails() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("superhero", new Superhero());
		modelAndView.setViewName("superheroes/AddSuperhero.html");
		return modelAndView;
	}

	@RequestMapping("/superheroes/add-superhero")
	public ModelAndView addSuperheroPageController(@ModelAttribute("superhero") Superhero superhero) {
		ModelAndView modelAndView = new ModelAndView();
		String message = null;
		if (superheroService.addSuperhero(superhero) == 1) {
			message = "Superhero was added!";
		} else {
			message = "Superhero was not added!";
		}
		modelAndView.addObject("message", message);
		modelAndView.setViewName("/superheroes/Output");
		return modelAndView;
	}

	// form to search a superhero by id
	@RequestMapping("/superheroes/input-superhero-id")
	public ModelAndView inputSuperheroIdController() {
		return new ModelAndView("/superheroes/InputSuperheroId.html");
	}

	@RequestMapping("/show-superhero-by-id")
	public ModelAndView searchSuperheroPageController(@RequestParam("superheroId") int superheroId) {
		ModelAndView modelAndView = new ModelAndView();
		Superhero superhero = superheroService.getSuperheroById(superheroId);
		if (superhero != null) {
			modelAndView.addObject("superhero", superhero);
			modelAndView.setViewName("/superheroes/DisplaySuperheroByID.html");
		} else {
			modelAndView.addObject("message", "Superhero with ID " + superheroId + " does not exist.");
			modelAndView.setViewName("/superheroes/Output");
		}
		return modelAndView;
	}

	// show all superheroes
	@RequestMapping("/superheroes/show-all-superheroes")
	public ModelAndView showAllSuperheroesPageController() {
		ModelAndView modelAndView = new ModelAndView();

		List<Superhero> superheroesList = superheroService.getAllSuperheroes();
		modelAndView.addObject("superheroList", superheroesList);
		modelAndView.setViewName("superheroes/DisplayAllSuperheroes.html");
		return modelAndView;
	}

	// form to search a superhero by id and then delete it
	@RequestMapping("/superheroes/input-superhero-id-for-delete")
	public ModelAndView inputSuperheroIdForDeleteController() {
		return new ModelAndView("/superheroes/InputSuperheroIdForDelete.html");
	}

	@RequestMapping("/delete-superhero-by-id")
	public ModelAndView deleteSuperheroController(@RequestParam("superheroId") int superheroId) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("Testing delete method.");
		if (superheroService.deleteSuperhero(superheroId)) {
			modelAndView.addObject("message", "Superhero with ID " + superheroId + " was deleted!");
			modelAndView.setViewName("superheroes/Output");
		} else {
			modelAndView.addObject("message", "Superhero with ID " + superheroId + " was not deleted!");
			modelAndView.setViewName("superheroes/Output");
		}
		return modelAndView;
	}

	// Update Superhero - part 1
	@RequestMapping("superheroes/input-superhero-id-for-update")
	public ModelAndView inputSuperheroIdForUpdateController() {
		return new ModelAndView("/superheroes/InputSuperheroIdForUpdate.html");
	}

	// Update Superhero - part 2
	@RequestMapping("superheroes/search-superhero")
	public ModelAndView searchSuperheroById(@RequestParam("superheroId") int superheroId) {
		ModelAndView modelAndView = new ModelAndView();
		Superhero superhero = superheroService.getSuperheroById(superheroId);
		if (superhero != null) {
			Superhero newSuperhero = new Superhero();
			newSuperhero.setSuperheroId(superheroId);
			newSuperhero.setSuperheroName(superhero.getSuperheroName());
			newSuperhero.setSuperheroName(superhero.getSuperheroName());
			newSuperhero.setSuperheroDescription(superhero.getSuperheroDescription());
			newSuperhero.setSuperheroSuperpower(superhero.getSuperheroSuperpower());

			modelAndView.addObject("newSuperhero", newSuperhero);
			modelAndView.addObject("superhero", superhero);
			modelAndView.setViewName("superheroes/InputSuperheroDetailsForUpdate.html");
		} else {
			modelAndView.addObject("message", "Superhero with ID " + superheroId + " does not exist.");
			modelAndView.setViewName("superheroes/Output.html");
		}
		return modelAndView;
	}

	// Update Superhero - part 3
	@RequestMapping("/superheroes/update-superhero-details")
	public ModelAndView updateSuperheroDetails(@ModelAttribute("newSuperhero") Superhero superhero) {
		ModelAndView modelAndView = new ModelAndView();

		if (superheroService.updateSuperhero(superhero)) {
			modelAndView.addObject("message", "Superhero has been updated.");
			modelAndView.setViewName("superheroes/Output.html");
		} else {
			modelAndView.addObject("message", "Superhero could not be updated.");
			modelAndView.setViewName("superheroes/Output.html");
		}
		return modelAndView;
	}
}
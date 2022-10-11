package com.kenya.dojoninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kenya.dojoninjas.models.Dojo;
import com.kenya.dojoninjas.models.Ninja;
import com.kenya.dojoninjas.service.DojoService;
import com.kenya.dojoninjas.service.NinjaService;

@Controller
public class DojoNinjaController {

	@Autowired
	private NinjaService ninjaService;

	@Autowired
	private DojoService dojoService;

	
	// Setup for post method for DOJO
	@GetMapping("/dojo")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo, Model model) {
		List<Dojo> allDaDojos = dojoService.allDojos();
		model.addAttribute("allDojos", allDaDojos);
		return "createDojo.jsp";
	}

	// ========= Create new DOJO ============ 
	@PostMapping("/dojos")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult res, Model model) {
		if (res.hasErrors()) {
			List<Dojo> allDaDojos = dojoService.allDojos();
			model.addAttribute("allDojos", allDaDojos);
			return "createDojo.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/dojo";
		}
	}
	
	// ==== Get one by ID =========
	@GetMapping("/dojo/{id}")
	public String getDojo(@PathVariable("id") Long dojoId, Model model) {
		Dojo thisDojo = dojoService.showOne(dojoId);
		model.addAttribute("thisDojo", thisDojo);
		return "oneDojo.jsp";
	}
	
	// =========== Setup Method for post method for NINJA ========
	@GetMapping("/ninja")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		// passing our dojos to assign a ninja to a dojo 
		List<Dojo> allDojos = dojoService.allDojos();
		model.addAttribute("allDojos", allDojos);
		return "createNinja.jsp";
	}


	// ========== Create new NINJA ===================
	@PostMapping("/ninjas")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Dojo> allDojos = dojoService.allDojos();
			model.addAttribute("allDojos", allDojos);
			List<Ninja> allNinjas = ninjaService.allNinjas();
			model.addAttribute("allNinjas", allNinjas);
			return "createNinja.jsp";
		} else {
			ninjaService.createDojo(ninja);
			return "redirect:/ninja";
		}
	}
	
	
}

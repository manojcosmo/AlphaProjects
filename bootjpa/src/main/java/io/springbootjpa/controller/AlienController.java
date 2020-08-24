package io.springbootjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import io.springbootjpa.entities.Alien;
import io.springbootjpa.repository.AlienRepo;

@Controller
public class AlienController {
	@Autowired
	AlienRepo alienrepo;

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		/*
		 * ModelAndView mv = new ModelAndView(); mv.addObject("obj", alien);
		 * mv.setViewName("details");
		 */
		alienrepo.save(alien);
		return "home";
	}

	@RequestMapping("/getId")
	public ModelAndView getById(@RequestParam int aid) {
		ModelAndView mv = new ModelAndView("details");
	Alien alien = 	alienrepo.findById(aid).orElse(new Alien());
		mv.addObject(alien);
		return mv;
	}

}

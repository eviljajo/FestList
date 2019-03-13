package com.festlist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.festlist.model.Festival;
import com.festlist.service.FestivalService;

@Controller
public class MainController  {
	
	
	private  FestivalService festivalService;

	@Autowired
	public MainController(FestivalService festivalService) {
		this.festivalService = festivalService;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String addFest(Model model) {
		model.addAttribute("festival", new Festival());
		return "addfest";
	}
	
	@RequestMapping(value ="/festival", method = RequestMethod.GET)
	public String festivalList(Model model) {
		model.addAttribute("festival", festivalService.getAllFestivals());
		return "festival";
	}
	
	@RequestMapping(value = "/festival", method = RequestMethod.POST)
	public String festivals(@ModelAttribute Festival festival, Model model) {
	festivalService.createFestival(festival);
	model.addAttribute("festival", festivalService.getAllFestivals());
	return "festival";
	}
	
	
	

}

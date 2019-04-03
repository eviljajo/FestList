package com.festlist.controllers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.festlist.model.Festival;
import com.festlist.service.FestivalService;

import ch.qos.logback.core.net.SyslogOutputStream;

@Controller
public class MainController  {
	
	
	private  FestivalService festivalService;

	@Autowired
	public MainController(FestivalService festivalService) {
		this.festivalService = festivalService;
	}
	
	@RequestMapping(value = "/addfest", method = RequestMethod.GET)
	public String addFest(Model model) {
		model.addAttribute("festival", new Festival());
		return "addfest";
	}
	
	@RequestMapping(value ="/", method = RequestMethod.GET)
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
	

	@RequestMapping(value ="/delete/{id}", method = RequestMethod.GET)
	public String deleteFestival(@PathVariable Long id, Model model) {
		festivalService.deleteFestival(id);
		 return "redirect:/";
	}
	

    @RequestMapping("/festival/{name}")
    public String showProduct(@PathVariable String name, Model model){
    		
       		model.addAttribute("festival", festivalService.getFestivalByName(name));
        return "festivalshow";
}
	

	
	

}

package com.spring.app.project.controller;

//import java.lang.System.Logger;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.app.project.customerService.Service.IBoardCustomerService_SERVICE;
import com.spring.app.project.recipe.dto.Recipe_DTO;
import com.spring.app.project.recipe.service.IRecipeService;



@Controller
public class Project {
	
	@Autowired
	IRecipeService rService;
	@Autowired
	IBoardCustomerService_SERVICE csService;

	
//	硫붿씤�솕硫�
	@RequestMapping(value = "/")
	public String index(HttpSession session, Model model){
		Recipe_DTO recipe = rService.selectRecipeRno(241);
		Recipe_DTO chicken = rService.selectRecipeRno(242);
		Recipe_DTO kimchPork = rService.selectRecipeRno(243);
		Recipe_DTO fishCake = rService.selectRecipeRno(244);
		model.addAttribute("recipe" , recipe);
		model.addAttribute("chicken" , chicken);
		model.addAttribute("kimchPork" , kimchPork);
		model.addAttribute("fishCake" , fishCake);
		
		if(session.getAttribute("login") !=null) {
			
			return "indexLogin";
			
		}else {
			
			return "index";
		}
	}
	

}


package com.portal.web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.portal.core.model.User;


@Controller
@EnableWebMvc
public class LoginController
{
	  @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
	        model.addAttribute("name", name);
	        System.out.println("***************************************************1");
	        return "login";
	    }
	  
	  @RequestMapping(value = "/perform_login", method = RequestMethod.GET)
	    public String performLogin(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
	        model.addAttribute("name", name);
	        System.out.println("***************************************************1");
	        return "homepage";
	    }
	  
	  @RequestMapping(value = "/homepage", method = RequestMethod.GET)
	    public String homepage(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
	        model.addAttribute("name", name);
	        System.out.println("***************************************************1");
	        return "homepage";
	    }
	  
	  @RequestMapping(value="/registration", method = RequestMethod.GET)
	  public ModelAndView registration() {
		  ModelAndView modelAndView = new ModelAndView();
		  User user = new User();
		  modelAndView.addObject("user",user);
		  modelAndView.setViewName("registration");
		  return modelAndView ;
	  }
}
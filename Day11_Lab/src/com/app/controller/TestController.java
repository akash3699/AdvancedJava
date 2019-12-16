package com.app.controller;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // Mandatory
@RequestMapping("/test") //optional BUT reco --for separation
public class TestController {

	public TestController() {
		System.out.println("in ctor of "+getClass().getName());
	}
	
	//request handling method for M&V
	@GetMapping("/test2")//@GetMapping = @RequestMapping + method=get
	public ModelAndView sayHello()
	{
		System.out.println("in say hello2");
		return new ModelAndView("/home","server_date",LocalDateTime.now());
	}
	
	//request handling to understand model
	//o.s.ui.model -- i/f -- map of modelattrs
	@GetMapping("/test3")
	public String sayHello3(Model map)
	{
		System.out.println("in say hello 3"+map);
		//add attributes
		map.addAttribute("server_date",LocalDateTime.now());
		map.addAttribute("nums",Arrays.asList(1,2,3,4,5));
		System.out.println(map);
		return "/home";
	}
}

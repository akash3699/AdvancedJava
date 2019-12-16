package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	public HelloController() {
		System.out.println("in ctor of "+getClass().getName());
	}
	
	@RequestMapping("/test1")
	public String sayHello1()
	{
		System.out.println("in say Hello1");
		return "/home";
	}
}

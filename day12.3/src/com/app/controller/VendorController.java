package com.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.IUserDao;
import com.app.dao.IVendorDao;
import com.app.pojos.AcType;
@Controller
@RequestMapping("/vendor")
public class VendorController {
	
	@Autowired
	private IVendorDao dao;
	public VendorController() {
		System.out.println("in ctor of "+getClass().getName());
	}
	//request handling method to forward the clnt to details page
	@GetMapping("/details")
	public String showVendorDetails()
	{
		System.out.println("in show vendor dtls");
		return "/vendor/details";
	}
	
	@GetMapping("/addAccount")
	public String addAccount(HttpServletRequest hs)
	{
		hs.setAttribute("AcType", AcType.values());
		System.out.println("in addAccount vendor dtls");
		return "/vendor/addAccount";
	}
	
	@PostMapping("/addAccount")
	public String addAccount(@RequestParam int vid,@RequestParam  String actype, @RequestParam double balance)
	{
		System.out.println("in addAccount vendor dtls");
		
		return "redirect:/vendor/details";
	}
}

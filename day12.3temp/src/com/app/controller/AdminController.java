package com.app.controller;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IVendorDao;
import com.app.pojos.UserRole;
import com.app.pojos.Vendor;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private IVendorDao dao;
	public AdminController() {
		System.out.println("in ctor of "+getClass().getName());
	}
	//request handling method for listing all vendors
	@GetMapping("/list")
	public String showVendorList(Model map)
	{
		System.out.println("in show vendor list");
		//invoke dao's method
		map.addAttribute("vendor_list",dao.listVendors());
		return "/admin/list";//forward view name
	}
	//request handling method to delete vendor details
	@GetMapping("/delete")
	public String deleteVendorDetails(@RequestParam int vid,RedirectAttributes flashMap)
	{
		System.out.println("in del vendor dtls");
		//invoke dao's method
		flashMap.addFlashAttribute("mesg",dao.deleteVendorDetails(vid));
		//redirect view
		return "redirect:/admin/list";
	}
	
	//request handling method for adding vendor
		@GetMapping("/add")
		public String addVendor()
		{
			System.out.println("in add vendor");
			return "/admin/add";//forward view name
		}
		
	//request handling method to add vendor details
	@PostMapping("/add")
	public String addVendorDetails(@RequestParam String nm,@RequestParam String em,@RequestParam String pass,@RequestParam double regAmount, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date regDate ,RedirectAttributes flashMap)
	{
		System.out.println("in add vendor dtls");
		//invoke dao's method
		flashMap.addFlashAttribute("mesg",dao.addVendorPojo(new Vendor(nm,em,pass,regAmount,regDate,UserRole.VENDOR)));
		//redirect view
		return "redirect:/admin/list";
	}
	
	//request handling method to update vendor details
	@GetMapping("/update")
	public String updateVendorDetails(@RequestParam int vid, Model Map)
	{
		System.out.println("in update vendor dtls");
		//invoke dao's method
//		flashMap.addFlashAttribute("mesg",dao.deleteVendorDetails(vid));
		Map.addAttribute("update_use_dtls",dao.getVendorPojo(vid));
		//redirect view
		return "/admin/update";
	}
	
	//request handling method to add vendor details
	@PostMapping("/update")
	public String updateVendorDetails(@RequestParam int vid,@RequestParam String nm,@RequestParam String em,@RequestParam String pass,@RequestParam double regAmount, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date regDate ,RedirectAttributes flashMap)
	{
		System.out.println("in update vendor dtls");
		//invoke dao's method
		flashMap.addFlashAttribute("mesg",dao.updateVendorPojo(new Vendor(nm,em,pass,regAmount,regDate,UserRole.VENDOR), vid));
		//redirect view
		return "redirect:/admin/list";
	}

}

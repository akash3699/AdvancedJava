package com.app.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.IProductDao;
import com.app.pojos.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
	//dependancy
	@Autowired
	private IProductDao dao;

	public ProductController() {
	
		System.out.println("in ctor of product");
	}
	
	//request handling method to handle request params
	//request params names MUST match with method of argument name
	@GetMapping("/add")
	public String addProduct(@RequestParam(name="nm") String name, 
			@RequestParam double price,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date exp_date, 
			Model map)
	{
		System.out.println("in add product"+name+price+exp_date);
		//create a product from req params
		Product p = new Product(name,price,exp_date);
		//store product details under model map
		map.addAttribute("product_dtls",p);
		return "/product/add";
	}
	
	//request handling method to get list of product
	@GetMapping("/list")
	public String getProducts(Model map)
	{
		System.out.println("in get_prods");
		map.addAttribute("product_list",dao.listAllProducts());
		return "/product/list";
	}
}

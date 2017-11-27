package com.iia.eShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iia.eShop.entity.Product;
import com.iia.eShop.repository.ProductRepository;

@Controller
public class ProductController {
	
		@Autowired
	     private ProductRepository productRepo;
	 
	     @RequestMapping("/product/index")
	     public String index(Model model) {
	 
	         List<Product> products = (List<Product>) productRepo.findAll();
	         model.addAttribute("products", products);
	 
	        return "product/index";
	    }
	 

}

package com.iia.eShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iia.eShop.entity.Product;
import com.iia.eShop.entity.Customer;
import com.iia.eShop.repository.ProductRepository;
import com.iia.eShop.repository.CustomerRepository;

@Controller
@RequestMapping("/")
public class DefaultController {
	
	 @Autowired
     private ProductRepository productRepo;
	 
	 @Autowired
     private CustomerRepository custoRepo;
	 
		
	@RequestMapping("/")
	public String home(Model model) {	
		
		List<Product> products = (List<Product>) productRepo.findAll();
        Customer customer = custoRepo.findOne(Long.valueOf(1));
        
		model.addAttribute("customer", customer);
		model.addAttribute("products", products);
        
		return "home/home";
	}
	

}

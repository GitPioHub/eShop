package com.iia.eShop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iia.eShop.entity.Product;
import com.iia.eShop.repository.ProductRepository;

@Controller
@RequestMapping("/product/")
public class ProductController {
	
		 @Autowired
	     private ProductRepository productRepo;
	 
	     @RequestMapping("index")
	     public String index(Model model) {
	    	 //Integer result = (Integer)session.getAttribute("toto");
	         List<Product> products = (List<Product>) productRepo.findAll();
	         model.addAttribute("products", products);
	         //session.setAttribute("toto", 23);
	 
	        return "product/index";
	    }
	 
	     
	     @RequestMapping("{id}")
	     public String display(@PathVariable String id, Model model) {
	 
	    	 Product product = productRepo.findOne(Long.valueOf(id));
	         model.addAttribute("product", product);
	 
	        return "product/display";
	    }

}

package com.iia.eShop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iia.eShop.entity.Customer;
import com.iia.eShop.entity.Product;
import com.iia.eShop.repository.CustomerRepository;
import com.iia.eShop.repository.ProductRepository;

@Controller
@RequestMapping("/customer/")
public class CustomerController {

	@Autowired
    private CustomerRepository custoRepo;
	
	@RequestMapping("customer")
    public String customer(Model model) {
   	 
        Customer customer = custoRepo.findOne(Long.valueOf(1));
        model.addAttribute("customer", customer);    

       return "/";
   }
}

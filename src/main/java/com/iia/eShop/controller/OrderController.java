package com.iia.eShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iia.eShop.entity.Order;
import com.iia.eShop.entity.Product;
import com.iia.eShop.entity.ProductOrder;
import com.iia.eShop.repository.OrderRepository;
import com.iia.eShop.repository.ProductRepository;


@Controller
@RequestMapping("/order/")
public class OrderController {
	
	 @Autowired
     private OrderRepository orderRepository;
	 
	 @Autowired
	 private ProductRepository productrepository;
	 

	 @RequestMapping("myorder")
     public String myorder(Model model) {
  
         List<Order> orders = (List<Order>) orderRepository.findAll();
         model.addAttribute("order", orders);
         
        return "order/myorder";
    }
	 
	  	@RequestMapping("{id}")
	     public String displayorder(@PathVariable String id, Model model) {
	 
	    	 Order order = orderRepository.findOne(Long.valueOf(id));
	    	 List<ProductOrder> products = (List<ProductOrder>) order.getOrderedProduct();
	         model.addAttribute("order", order);
	         model.addAttribute("product", products);

	 
	        return "order/displayorder";
	    }
}

package com.iia.eShop;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.iia.eShop.entity.Customer;
import com.iia.eShop.entity.Order;
import com.iia.eShop.entity.Product;
import com.iia.eShop.entity.StateOrder;
import com.iia.eShop.repository.CustomerRepository;
import com.iia.eShop.repository.ProductRepository;
import com.iia.eShop.repository.OrderRepository;


/**
 *  Main application
 * @author Pierre Deffay
 *
 */
@SpringBootApplication
public class Application {

    private static final Logger log =
            LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Inserts customers, products and orders into the mysql database and displays on the console the added elements
     * @param customerRepository
     * @param orderRepository
     * @param productRepository
     * @return
     */
    @Bean
    public CommandLineRunner demo(CustomerRepository customerRepository, OrderRepository orderRepository, ProductRepository productRepository) {
        return (args) -> {
        	    	
        
        	customerRepository.deleteAll();
        	productRepository.deleteAll();
        	        	
            Customer customer1 = new Customer("Mickael", "Gaillard", "555555555", "5 rue des oui", 53000, "laval");                                            
            Order order1 = new Order("12/01/2015", StateOrder.COMPLETE, 125849.15f); 
            customer1.addOrder(order1);
         
            // Add customers.
            log.info("Add Customers fixtures...");
            customerRepository.save(customer1);
            
            // Add products.
            Product product1 = new Product("Chapeau", "ceci n'est pas un chapeau", 8, false, 55.45F);                           
            productRepository.save(product1);     
            
            // Add orders.
            order1.addProduct(product1, 1);
            orderRepository.save(order1);
           
            
            
            
           
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer cus : customerRepository.findAll()) {
                log.info(cus.toString());
            }
            log.info("");
            
            log.info("Products found with findAll():");
            log.info("-------------------------------");
            for (Product pro : productRepository.findAll()) {
                log.info(pro.toString());
            }
            log.info("");
            
            log.info("Orders found with findAll():");
            log.info("-------------------------------");
            for (Order ord : orderRepository.findAll()) {
                log.info(ord.toString());
            }
            log.info("");
        };

    }
    
}   
    
   

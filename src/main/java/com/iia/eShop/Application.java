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
        	    	
        	orderRepository.deleteAll();
        	customerRepository.deleteAll();
        	productRepository.deleteAll();
        	        	
            Customer customer1 = new Customer("Mickael", "Gaillard", "555555555", "5 rue des oui", 53000, "laval");  
            Customer customer2 = new Customer("JACKY", "Dessler", "555555555", "5 rue des oui", 53000, "laval");
            Customer customer3 = new Customer("Chloe", "O'Brian", "555555555", "5 rue des oui", 53000, "laval");
            Customer customer4 = new Customer("Kim", "Bauer", "555555555", "5 rue des oui", 53000, "laval");
            Customer customer5 = new Customer("David", "Palmer", "555555555", "5 rue des oui", 53000, "laval");
            Customer customer6 = new Customer("Michelle", "Dessler", "555555555", "5 rue des oui", 53000, "laval");            
            customerRepository.save(customer1);           
            customerRepository.save(customer2);        
            customerRepository.save(customer3);           
            customerRepository.save(customer4);        
            customerRepository.save(customer5);         
            customerRepository.save(customer6);
            
            
            
            Product product1 = new Product("Chapeau", "ceci n'est pas un chapeau", 8, false, 55.45F);        
            Product product2 = new Product("Chapeau de paille", "ceci n'est pas un chapeau de paille", 12, false, 41.45F);
            Product product3 = new Product("Paille", "ceci n'est pas une paille", 5, false, 85.45F);
            Product product4 = new Product("Tarte", "ceci n'est pas une tarte", 2, false, 96.45F);
            Product product5 = new Product("TATA", "ceci n'est pas une tata", 55, false, 55.F);                       
            productRepository.save(product1);
            productRepository.save(product2);
            productRepository.save(product3);
            productRepository.save(product4);
            productRepository.save(product5);
            
            
            
            Order order1 = new Order("12/01/2015", StateOrder.COMPLETE, 125849.15f, customer1);                     
            Order order2 = new Order("15/09/2016", StateOrder.COMPLETE, 849.15f, customer2);
            Order order3 = new Order("25/01/2013", StateOrder.IN_PROGRESS, 1.15f, customer3);
            orderRepository.save(order1);
            orderRepository.save(order2);
            orderRepository.save(order3);

 
            
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
    
   

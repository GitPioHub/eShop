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
        	        	
            Customer customer = new Customer("Pierre", "Deffay", "555555555", "5 rue des oui", 53000, "laval","123", "123");                                            
            Order order1 = new Order("12/01/2015", StateOrder.COMPLETE, 125849.15f); 
            Order order2 = new Order("13/03/2014", StateOrder.IN_PROGRESS, 1244.16f);
            customer.addOrder(order1);
            customer.addOrder(order2);
            
         
            // Add customers.
            log.info("Add Customers fixtures...");
            customerRepository.save(customer);
            
            // Add products.
            Product product1 = new Product("Chapeau", "Dealez de la meth en toute sécurité grâce à ce chapeau passe-partout", 8, false, 55.45F, "/images/photo1.jpg");
            Product product2 = new Product("Bateau", "Pratique à la mer, moins en appartement", 6, false, 12.6F, "/images/photo2.jpg");
            Product product3 = new Product("Chaise", "Pratique en appartement, moins à la mer", 2, false, 5.12F, "/images/photo3.jpg");           
            Product product4 = new Product("Pull", "Winter is coming", 15, false, 35.14F, "/images/photo4.jpg");
            Product product5 = new Product("Trottoir", "Devenez propriétaire d'un bout de trottoir situé en Charente-Maritime", 1, false, 125.14F, "/images/photo5.jpg");
            Product product6 = new Product("Pavé", "Véritable pavé lançé par Nicolas Sarkozy en mai 68", 0, false, 55.14F, "/images/photo6.jpg");
            Product product7 = new Product("Perruche", "la pas de blague, c'est juste une perruche", 36, false, 12.14F, "/images/photo7.jpg");
            Product product8 = new Product("Trampoline", "ceci n'est pas un Pavé", 11, false, 69.14F, "/images/photo8.jpg");
         
            
            productRepository.save(product1);
            productRepository.save(product2); 
            productRepository.save(product3); 
            productRepository.save(product4); 
            productRepository.save(product5); 
            productRepository.save(product6); 
            productRepository.save(product7); 
            productRepository.save(product8); 
            
            
            // Add orders.
            order1.addProduct(product1, 1);
            order1.addProduct(product2, 2);
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
        };

    }
    
}   
    
   

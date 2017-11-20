package com.iia.eShop.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Class Product to generate in mysql database
 * @author Pierre Deffay
 * 
 */
@Entity
@Table(name = "product")
public class Product {
	/** id of the Product */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    /** name of the Product */
    @Column
    private String name;
    /** description of the Product */
    @Column
   	private String description;
    /** quantity of the Product */
   	@Column
    private int quantity;
   	/** determinate if the product is sold-out or not */
   	@Column
    private boolean dead;
   	/** price of the Product */
   	@Column
    private float price;
   	  
   	  
     /**
     * Empty constructor of the Product class
     */
    protected Product() {}
      
    
      /**
       * Constructor of the Product class
     * @param name
     * @param description
     * @param quantity
     * @param dead
     * @param price
     */
    public Product (String name, String description, int quantity, boolean dead, float price) {
      	this.name = name;
      	this.description = description;
      	this.quantity = quantity;
      	this.dead = dead;
      	this.price = price;
      }
      
    
    /** 
     * Return all information concerning a Order to string
     */
      @Override
	    public String toString() {
	        return String.format("Product[name='%s', description='%s', quantity='%s', dead='%s', price='%s']", this.name , this.description, this.quantity, this.dead, this.price);
	    }
      
  
      /**
       * Defines a many-valued association to Order
       */
	  	@ManyToMany(targetEntity = Order.class, mappedBy = "products")
	  	private Set<Order> orders = new HashSet<>();
	  	
	  	
	  	/**
	  	 * @return the orders
	  	 */
	  	public Set<Order> getOrders() {
	  		return orders;
	  	}
	
	  	/**
	  	 * @param orders A list of orders to set
	  	 * @return this orders
	  	 */
	  	public Product setOrders(Set<Order> orders) {
	  		this.orders = orders;
	  		return this;
	  	}
	 
	  	
    
	    /**
		 * @return the id
		 */
		public Long getId() {
			return id;
		}
	
		/**
		 * @param id the id to set
		 */
		public void setId(Long id) {
			this.id = id;
		}
	
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
	
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
	
		/**
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}
	
		/**
		 * @param description the description to set
		 */
		public void setDescription(String description) {
			this.description = description;
		}
	
		/**
		 * @return the quantity
		 */
		public int getQuantity() {
			return quantity;
		}
	
		/**
		 * @param quantity the quantity to set
		 */
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
	
		/**
		 * @return the dead
		 */
		public boolean isDead() {
			return dead;
		}
	
		/**
		 * @param dead the dead to set
		 */
		public void setDead(boolean dead) {
			this.dead = dead;
		}
	
		/**
		 * @return the price
		 */
		public float getPrice() {
			return price;
		}
	
		/**
		 * @param price the price to set
		 */
		public void setPrice(float price) {
			this.price = price;
		}

   
}

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
public class Product extends EntityBase{

	
    /** name of the Product */
    @Column(unique=true)
    private String name;
    /** description of the Product */
    @Column(length=255)
   	private String description;
    /** quantity of the Product */
   	@Column
    private int quantity = 0;
   	/** determinate if the product is sold-out or not */
   	@Column
    private boolean dead;
   	/** price of the Product */
   	@Column(precision=2)
    private float price;
   	
    /** name of the photoProduct */
    @Column
    private String pathPhoto;
   	  
   	  
     public String getPathPhoto() {
		return pathPhoto;
	}


	public void setPathPhoto(String pathPhoto) {
		this.pathPhoto = pathPhoto;
	}


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
    public Product (String name, String description, int quantity, boolean dead, float price, String pathPhoto) {
      	this.name = name;
      	this.description = description;
      	this.quantity = quantity;
      	this.dead = dead;
      	this.price = price;
      	this.pathPhoto = pathPhoto;
      }
      
    
    	/** 
    	 * Return all information concerning a Order to string
    	 */
      	@Override
	    public String toString() {
	        return String.format("Product[name='%s', description='%s', quantity='%s', dead='%s', price='%s']", this.name , this.description, this.quantity, this.dead, this.price);
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

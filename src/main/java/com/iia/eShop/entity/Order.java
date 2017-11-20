package com.iia.eShop.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Class Order to generate in mysql database
 * @author Pierre Deffay
 *
 */
@Entity
@Table(name = "my_order")
public class Order {
		/** id of the order */
	 	@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Long id;
	 	/** date of the order */
	    @Column
	    private String date;
	    /** state of the order */
	    @Column
	    private StateOrder state;
	    /** total price of the order */
	    @Column
	    private float totalPrice;
	    	    
	    
	    /**
	     * Empty constructor of the Customer class
	     */
	    protected Order() {}
	    
	    
	    /**
	     * Constructor of the Order class
	     * @param date
	     * @param state
	     * @param totalprice
	     * @param customer
	     */
	    public Order(String date, StateOrder state, float totalprice, Customer customer) {
	        this.date = date;
	        this.state  = state;
	        this.totalPrice = totalprice;
	        this.customer = customer;	        
	    }
	    
	    /** 
	     * Return all information concerning a Order to string
	     */
	    @Override
	    public String toString() {
	        return String.format("Order[date='%s', state='%s', totalprice='%s']", this.date , this.state, this.totalPrice);
	    }
	    
	    
	    
	    /**
	     * Defines a many-valued association to Customer
	     */
	    @ManyToOne
		private Customer customer;
	   	   
	    
	 	/**
	 	 * @return a Customer
	 	 */
	 	public Customer getCustomer() {
			return customer;
		}
	 	
		
		/**
		 * @param customer a Customer to set 
		 * @return the Order 
		 */
		public Order setCustomer(Customer customer) {
			this.customer = customer;
			return this;			
		}
		
		
		
		/**
	     * Defines a many-valued association to Product
	     * by joining the product_order table
	     */
		@ManyToMany(targetEntity = Product.class, cascade=CascadeType.MERGE)
		
		@JoinTable(
				name = "product_order",
				joinColumns = @JoinColumn(name = "order_id"),
				inverseJoinColumns = {@JoinColumn(name = "product_id")})
		private Set<Product> products = new HashSet<>();

		/**
		 * @return the products
		 */
		public Set<Product> getProducts() {
			return products;
		}

		
		/**
		 * @param products the product to set
		 * @return this Order
		 */
		public Order setProducts(Set<Product> products) {
			this.products = products;
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
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * @return the state
	 */
	public StateOrder getState() {
		return state;
	}
	
	/**
	 * @param state the state to set
	 */
	public void setState(StateOrder state) {
		this.state = state;
	}
	
	/**
	 * @return the totalPrice
	 */
	public float getTotalPrice() {
		return totalPrice;
	}
	
	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
		

	    
}

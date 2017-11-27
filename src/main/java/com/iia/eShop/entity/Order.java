package com.iia.eShop.entity;

import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Class Order to generate in mysql database
 * @author Pierre Deffay
 *
 */
@Entity
@Table(name = "my_order")
public class Order extends EntityBase{
		
	
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
	     * Defines a many-valued association to Customer
	     */
	    @ManyToOne
		private Customer customer;
	    
		/**
	     * Defines a many-valued association to Product
	     * by joining the product_order table
	     */
		 @OneToMany(mappedBy="order", cascade=CascadeType.ALL)
		 private List<ProductOrder> products;
	    	    
	    /**
	     * Constructor of the Order class
	     * @param date
	     * @param state
	     * @param totalprice
	     * @param customer
	     */
	    public Order(String date, StateOrder state, float totalprice) {
	        this.date = date;
	        this.state  = state;
	        this.totalPrice = totalprice;
	                
	        this.products = new ArrayList<ProductOrder>();
	    }
	     
	    protected Order() {}
	    
	    
	 	/**
	 	 * @return a Customer
	 	 */
	 	public Customer getCustomer() {
			return this.customer;
		}

		
	    /**
	     * @param customer the customer to set
	     */
	    public Order setCustomer(Customer customer) {
	        this.customer = customer;

	        // Bidirectional check
	        if (customer != null && !customer.getOrders().contains(this)) {
	            customer.addOrder(this);
	        }

	        return this;
	    }
	 	
	    /** 
	     * Return all information concerning a Order to string
	     */
	    @Override
	    public String toString() {
	        return String.format("Order[date='%s', state='%s', totalprice='%s']", this.date , this.state, this.totalPrice);
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

	    
		 public Order addProduct(Product product, int qt) {
		        ProductOrder item = new ProductOrder(this, product, qt);
		        this.products.add(item);

		        return this;
		    }
		 
		 public List<ProductOrder> getOrderedProduct(){
			 return this.products;
		 }
		 
		 
		 public void removeProduct(Product product, int qt) {
			 ProductOrder finded = null;
		        for (ProductOrder orderProduct : this.products) {
		            if (orderProduct.getProduct().equals(product)) {
		                finded = orderProduct;
		            }
		        }

		        finded.setQuantity(finded.getQuantity() - qt);
		        if (finded.getQuantity() <= 0) {
		            this.products.remove(finded);
		        }
		    }

		

	    
}

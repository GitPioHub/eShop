package com.iia.eShop.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Class Customer to generate in mysql database
 * @author Pierre Deffay
 * 
 */
@Entity
@Table(name = "customer")
public class Customer extends EntityBase{
	
   
    /** firstName of the Customer */
    @Column(nullable=false, length=255)
    private String firstName;
    
    /** lastName of the Customer */
    @Column(nullable=false, length=255)
    private String lastName;
    
    /** phone of the Customer */
    @Column(length=15)
    private String phone;  
    
    /** address of the Customer */
	@Column(length=255)
    private String address;  
	
	/** postalCode of the Customer */
    @Column
    private int cP;
    
    /** city of the Customer */
    @Column(length=25)
    private String city;
            

    /**
     * Defines a many-valued association to Order
     */
    @OneToMany(mappedBy="customer", cascade=CascadeType.PERSIST)
    private List<Order> orders;

    
    
    /**
     * Empty constructor of the Customer class
     */
    protected Customer() {}
    
    
    /**
     * Constructor of the Customer class
     * @param firstName
     * @param lastName
     * @param phone
     * @param address
     * @param cP
     * @param city
     */
    public Customer(String firstName, String lastName, String phone, String address, int cP, String city) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.phone = phone;
        this.address = address;
        this.cP = cP;
        this.city = city;
        
        this.orders = new ArrayList<Order>();      
    }
           
    
    /** 
     * Return all information concerning a Customer to string
     */
    @Override
    public String toString() {
        return String.format("Customer[firstName='%s', lastName='%s', phone='%s', address='%s', cP='%s', city='%s']", this.firstName , this.lastName, this.phone, this.address, this.cP, this.city);
    }
    

	    /**
	     * @return the firstName
	     */
	    public String getFirstName() {
	        return firstName;
	    }
	
	    /**
	     * @param firstName the firstName to set
	     */
	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }
	    
	    /**
	     * @return the lastName
	     */
	    public String getLastName() {
	        return lastName;
	    }
	
	    /**
	     * @param lastName the lastName to set
	     */
	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }
	    
	    /**
		 * @return the phone
		 */
		public String getPhone() {
			return phone;
		}
	
		/**
		 * @param phone the phone to set
		 */
		public void setPhone(String phone) {
			this.phone = phone;
		}
	
		/**
		 * @return the address
		 */
		public String getAddress() {
			return address;
		}
	
		/**
		 * @param address the address to set
		 */
		public void setAddress(String address) {
			this.address = address;
		}
	
		/**
		 * @return the cP
		 */
		public int getcP() {
			return cP;
		}
	
		/**
		 * @param cP the cP to set
		 */
		public void setcP(int cP) {
			this.cP = cP;
		}
	
		/**
		 * @return the city
		 */
		public String getCity() {
			return city;
		}
	
		/**
		 * @param city the city to set
		 */
		public void setCity(String city) {
			this.city = city;
		}
		
		
	    /**
	     * @return the orders
	     */
	    public List<Order> getOrders() {
	        return this.orders;
	    }


	    
	    
	    /**
	     * @param orders the orders to set
	     * @return this instance.
	     */
	    public Customer setOrders(List<Order> orders) {
	        this.orders = orders;

	        // Bidirectional check
	        for (Order order : orders) {
	            if (order.getCustomer() != this) {
	                order.setCustomer(this);
	            }
	        }

	        return this;
	    }
	    
	    
		
		
	/**
     * @param order the order to add
     * @return this instance.
     */
    public Customer addOrder(Order order) {
        this.orders.add(order);

        // Bidirectional check
        if (order.getCustomer() != this) {
            order.setCustomer(this);
        }

        return this;
    }
    

	    

	    /**
	     *
	     * @param order the order to remove
	     * @return this instance.
	     */
	    public Customer removeOrder(Order order) {
	        this.orders.remove(order);

	        // Bidirectional check
	        if (order.getCustomer() == this) {
	            order.setCustomer(null);
	        }

	        return this;
	    }						
    }

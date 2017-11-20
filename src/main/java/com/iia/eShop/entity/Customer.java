package com.iia.eShop.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Class Customer to generate in mysql database
 * @author Pierre Deffay
 * 
 */
@Entity
@Table(name = "customer")
public class Customer {
	/** id of the Customer */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)    
    private Long id;
    /** firstName of the Customer */
    @Column
    private String firstName;
    /** lastName of the Customer */
    @Column
    private String lastName;
    /** phone of the Customer */
    @Column
    private String phone;  
    /** address of the Customer */
	@Column
    private String address;  
	/** postalCode of the Customer */
    @Column
    private int cP;
    /** city of the Customer */
    @Column
    private String city;

    
    
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
        
    }

    /** 
     * Return all information concerning a Customer to string
     */
    @Override
    public String toString() {
        return String.format("Customer[firstName='%s', lastName='%s', phone='%s', address='%s', cP='%s', city='%s']", this.firstName , this.lastName, this.phone, this.address, this.cP, this.city);
    }

    
    /**
     * Defines a many-valued association to Order
     */
    @OneToMany(mappedBy="customer")
    private List<Order> orders;
    
    
	/**
	 * @return  the orders
	 */
	public List<Order> getOrders() {
		return orders;
	}

	
	/**
	 * @param orders A list of orders to set
	 * @return this order
	 */
	public Customer setOrders(List<Order> orders) {
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
			cP = cP;
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

    }

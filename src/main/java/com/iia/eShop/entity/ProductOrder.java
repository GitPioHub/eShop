package com.iia.eShop.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "product_order")
public class ProductOrder extends EntityBase{
	
	 protected int quantity = 1;
	
    @ManyToOne
    protected Product product;

    @ManyToOne
    protected Order order;

    
    
    protected ProductOrder() {}
    
    
    public ProductOrder(Order order, Product product, int qt) {
        this.order = order;
        this.product = product;
        this.quantity = qt;
    }
    
    
    public float getTotal() {
    	return this.product.getPrice() * this.quantity;
    }
    
    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return the order
     */
    public Order getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(Order order) {
        this.order = order;
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
    
    
}

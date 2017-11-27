package com.iia.eShop.repository;

import org.springframework.data.repository.CrudRepository;

import com.iia.eShop.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{

}

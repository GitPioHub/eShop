package com.iia.eShop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.iia.eShop.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}

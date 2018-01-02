package com.iia.eShop.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.iia.eShop.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	
	//List<Product> findByOrder(Long id);
}

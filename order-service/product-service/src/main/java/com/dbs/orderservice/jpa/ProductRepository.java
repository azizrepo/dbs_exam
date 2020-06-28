package com.dbs.orderservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.orderservice.model.OrderDetails;
import com.dbs.orderservice.model.ProductDetails;


@Repository
public interface ProductRepository extends JpaRepository<ProductDetails, Integer> {

}

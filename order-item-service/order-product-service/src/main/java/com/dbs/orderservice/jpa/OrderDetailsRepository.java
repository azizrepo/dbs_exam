package com.dbs.orderservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.orderservice.model.OrderDetails;


@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

}

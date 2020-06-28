package com.dbs.orderservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.stereotype.Service;

import com.dbs.orderservice.exception.NotFoundException;
import com.dbs.orderservice.jpa.OrderDetailsRepository;
import com.dbs.orderservice.model.OrderDetails;

@Service
public class OrderService {

	// Auto wired the repository to acess internal methods
	@Autowired
	OrderDetailsRepository orderDetailsRepository;

	public int createNewOrder(OrderDetails orderDetails) throws NotFoundException {
		
		int flag = 0;
		OrderDetails order = orderDetailsRepository.save(orderDetails);
		if (order != null) {
			flag = order.getOrderId();
		}else{
			throw new NotFoundException("Order data not saved ..Please provide correct json format");
			
		}

		return flag;

	}

	public OrderDetails getOrderDetailById(int id) throws NotFoundException {
		OrderDetails orderDetails = null;
		Optional<OrderDetails> optionalData = orderDetailsRepository.findById(id);
		if (optionalData.isPresent()) {
			orderDetails = optionalData.get();

		}else{
			
			throw new NotFoundException("Order id not found");
		}
		return orderDetails;
	}

	public List<OrderDetails> getOrderDetail() throws NotFoundException {
		OrderDetails orderDetails = null;
		List<OrderDetails> listData=null;
		
		try{
		listData = orderDetailsRepository.findAll();
		if (listData==null) {
		//	orderDetails = optionalData.get();
			throw new NotFoundException("No orders is placed till today");
			
		}
		}catch(Exception exception){
			throw new NotFoundException("No orders is placed till today");
				
			
		}
		return listData;
	}

	
	
}

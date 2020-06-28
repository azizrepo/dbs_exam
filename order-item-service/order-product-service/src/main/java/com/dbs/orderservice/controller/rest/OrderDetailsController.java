package com.dbs.orderservice.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.orderservice.exception.NotFoundException;
import com.dbs.orderservice.model.OrderDetails;
import com.dbs.orderservice.service.OrderService;

@RestController
public class OrderDetailsController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/dbs/orderdetails/create")
	public int createNewOrder(@RequestBody OrderDetails orderDetails)throws NotFoundException{
		
	
		int flag= orderService.createNewOrder(orderDetails);
		
if(flag==0){
	throw new NotFoundException("Due to json format data is not saved..try again");
	
		}
		return flag;
		
	}
	

	@GetMapping("/dbs/orderdetails/{orderid}")
	public OrderDetails getOrderDetailById(@PathVariable("orderid") int orderId)throws NotFoundException {
	
         OrderDetails details= orderService.getOrderDetailById(orderId);	

        if(details==null){
        	throw new NotFoundException("Order Id not found");
        	
        		}
        return details;	
	
	
	
	}
	@GetMapping("/dbs/orderdetails/list")
	public List<OrderDetails> getOrderDetail() throws NotFoundException {
	
        return orderService.getOrderDetail();	
	}
	
	
	
	
	
	
	

}

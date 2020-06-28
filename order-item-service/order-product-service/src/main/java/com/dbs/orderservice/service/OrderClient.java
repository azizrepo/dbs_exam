
package com.dbs.orderservice.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dbs.orderservice.model.OrderDetails;
import com.dbs.orderservice.model.ProductDetails;


@FeignClient("order-service")
public interface OrderClient {
	
	@PostMapping("/dbs/orderdetails/create")
	public int createNewOrder(@RequestBody OrderDetails orderDetails);	

@GetMapping("/dbs/orderdetails/{orderid}")
	public OrderDetails getOrderDetailById(@PathVariable("orderid") int orderId);
	


@GetMapping("/dbs/orderdetails/list")
	public List<OrderDetails> getOrderDetail();
	

}

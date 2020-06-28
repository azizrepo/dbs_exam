
package com.dbs.orderservice.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dbs.orderservice.model.OrderDetails;
import com.dbs.orderservice.model.ProductDetails;


@FeignClient("product-service")
public interface ProductClient {
	

    @PostMapping("/dbs/product/create")
	public int addNewProduct(@RequestBody ProductDetails productDetails);
	
@GetMapping("/dbs/product/{productid}")
	public ProductDetails getProductById(@PathVariable("productid") int productId) ;
	

@GetMapping("/dbs/product/list")
	public  List<ProductDetails> getProductDetails() ;

}

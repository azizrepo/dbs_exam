package com.dbs.orderservice.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.orderservice.exception.NotFoundException;
import com.dbs.orderservice.model.ProductDetails;
import com.dbs.orderservice.service.ProductService;



@RestController
public class ProductDetailsController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/dbs/product/create")
	public int addNewProduct(@RequestBody ProductDetails productDetails) throws NotFoundException{
		int saveDataId=0;
		try{
	saveDataId=	 productService.createNewProduct(productDetails);
		}catch(Throwable exception){
			throw new NotFoundException(exception.getMessage());
			
		}
	return saveDataId;
		
	}
	

	@GetMapping("/dbs/product/{productid}")
	public ProductDetails getProductDetailById(@PathVariable("productid") int productId) throws NotFoundException {
	
		ProductDetails  details=null;
	
        try{
          	details= productService.getProductDetailById(productId);
        	if(details==null){
        		throw new NotFoundException("product id not found");
        		
        	}
        	
        		}catch(Throwable exception){
        			throw new NotFoundException(exception.getMessage());
        			
        		}
        return details;
	}
	
	
	@GetMapping("/dbs/product/list")
	public  List<ProductDetails> getProductDetails() throws NotFoundException {
		List<ProductDetails> list=null;
        
        try{
        	list= productService.getProductDetails();
        	
        	
        
        }catch(Throwable exception){
        			throw new NotFoundException(exception.getMessage());
        			
        		}
        return list;
        
	}
	
	
	

}

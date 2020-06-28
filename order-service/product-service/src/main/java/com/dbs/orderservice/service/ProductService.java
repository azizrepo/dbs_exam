package com.dbs.orderservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.orderservice.jpa.ProductRepository;
import com.dbs.orderservice.model.OrderDetails;
import com.dbs.orderservice.model.ProductDetails;

import javassist.NotFoundException;

@Service
public class ProductService {

	// Auto wired the repository to acess internal methods
	@Autowired
	ProductRepository productRepository;

	
	public int createNewProduct(ProductDetails orderItemDetails) throws NotFoundException {
		int flag = 0;
		
		ProductDetails orderItem = productRepository.save(orderItemDetails);
		
		
		
		
		if (orderItem != null) {
			flag = orderItem.getProductCode();
		}else{
			throw new NotFoundException("Due to internal problem data not saved ..please the data is properply provided");
			
			
		}

		return flag;

	}

	public ProductDetails getProductDetailById(int id) throws NotFoundException {
		ProductDetails productDetails = null;
		Optional<ProductDetails> optionalData = productRepository.findById(id);
		if (optionalData.isPresent()) {
			productDetails = optionalData.get();

		}
		else{
			throw new NotFoundException("product id not found");
			
			
		}

		return productDetails;
	}

	public List<ProductDetails> getProductDetails() throws NotFoundException {
		ProductDetails productDetails = null;
		List<ProductDetails> dataList = productRepository.findAll();
		if (dataList.isEmpty()) {
			//productDetails = optionalData.get();
			
			throw new NotFoundException("No products add yet..");
			

		}
		
		return dataList;
	}

	
}

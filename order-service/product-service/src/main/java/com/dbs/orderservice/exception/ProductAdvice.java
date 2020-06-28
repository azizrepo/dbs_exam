package com.dbs.orderservice.exception;

import java.time.LocalDateTime;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
	
	public class ProductAdvice {
	
	 @ExceptionHandler(EntityNotFoundException.class)
	   protected ResponseEntity<Object> handleEntityNotFound(
	           EntityNotFoundException ex) {
		 ErroResponse erroResponse=new ErroResponse();
	    	erroResponse.setErrorMessage(ex.getMessage());
	      erroResponse.setDateTime(LocalDateTime.now());
	       erroResponse.setStatus(""+(HttpStatus.NOT_FOUND.value()));
	       return new ResponseEntity<>(erroResponse, HttpStatus.NOT_FOUND);
	   }

	
	
	    @ExceptionHandler(value = NotFoundException.class)
	
	    public ResponseEntity<ErroResponse> handleGenericNotFoundException(NotFoundException e) {
	
	    	ErroResponse erroResponse=new ErroResponse();
	    	erroResponse.setErrorMessage(e.getMessage());
	      erroResponse.setDateTime(LocalDateTime.now());
	       erroResponse.setStatus(""+(HttpStatus.NOT_FOUND.value()));
	
	        return new ResponseEntity<>(erroResponse, HttpStatus.NOT_FOUND);
	
	    }   
	
	
	}

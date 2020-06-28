package com.dbs.orderservice.exception;

import java.time.LocalDateTime;

public class ErroResponse {

	public ErroResponse() {
		// TODO Auto-generated constructor stub
	}

	private LocalDateTime dateTime;
	private String errorMessage;
	private String status;
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ErroResponse(LocalDateTime dateTime, String errorMessage, String status) {
		super();
		this.dateTime = dateTime;
		this.errorMessage = errorMessage;
		this.status = status;
	}
	
	
}

package com.dbs.orderservice.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "order_details")
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "order_id", nullable = false, length = 6)
	private int orderId;
	@Column(name = "order_customer_name", nullable = false, length = 20)

	private String customerName;
	@Column(name = "order_date", nullable = false)

	//@JsonFormat(pattern="yyyy-MM-dd")
	
	private LocalDate orderDate;
	@Column(name = "order_shipping_address", nullable = false, length = 100)

	private String shippingAddress;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "order_product_details", joinColumns = {
	@JoinColumn(name = "fk_product_code") }, 
	inverseJoinColumns = { @JoinColumn(name = "fk_order_id") })

	private List<ProductDetails> items;
	@Column(name = "order_total_amount", nullable = false, length = 6)

	private double totalAmount;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;

	
	
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", customerName=" + customerName + ", orderDate=" + orderDate
				+ ", shippingAddress=" + shippingAddress + ", items=" + items + ", totalAmount=" + totalAmount + "]";
	}

	public OrderDetails(int orderId, String customerName, LocalDate orderDate, String shippingAddress,
			List<ProductDetails> items, double totalAmount) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.orderDate = orderDate;
		this.shippingAddress = shippingAddress;
		this.items = items;
		this.totalAmount = totalAmount;
	}

	public List<ProductDetails> getItems() {
		return items;
	}

	public void setItems(List<ProductDetails> items) {
		this.items = items;
	}

	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


}

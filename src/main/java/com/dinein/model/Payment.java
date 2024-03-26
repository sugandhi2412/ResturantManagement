package com.dinein.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Payments")
public class Payment {
	
	@Id
	String id;
	String orderId;
	double totalAmount;
	double tipsAmount;
	String paymentMode;
	String paymentStatus;
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(String id, String orderId, double totalAmount, double tipsAmount, String paymentMode,
			String paymentStatus) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.totalAmount = totalAmount;
		this.tipsAmount = tipsAmount;
		this.paymentMode = paymentMode;
		this.paymentStatus = paymentStatus;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", orderId=" + orderId + ", totalAmount=" + totalAmount + ", tipsAmount="
				+ tipsAmount + ", paymentMode=" + paymentMode + ", paymentStatus=" + paymentStatus + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getTipsAmount() {
		return tipsAmount;
	}
	public void setTipsAmount(double tipsAmount) {
		this.tipsAmount = tipsAmount;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	
	
	
}

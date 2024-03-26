package com.dinein.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "order")
public class Order {
	
	@Id
	String id;
	String orderId;
	String custId;
	String reservationId;
	String tableNo;
	String slotTime;
	List<OrderItem> orderItems;
	String orderedDate;
	double amount;
	String paymentmode;
	String paymentstatus;
	String staffId;
	String status;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(String id, String orderId, String custId, String reservationId, String tableNo, String slotTime,
			List<OrderItem> orderItems, String orderedDate, double amount, String paymentmode, String paymentstatus,
			String staffId, String status) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.custId = custId;
		this.reservationId = reservationId;
		this.tableNo = tableNo;
		this.slotTime = slotTime;
		this.orderItems = orderItems;
		this.orderedDate = orderedDate;
		this.amount = amount;
		this.paymentmode = paymentmode;
		this.paymentstatus = paymentstatus;
		this.staffId = staffId;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderId=" + orderId + ", custId=" + custId + ", reservationId=" + reservationId
				+ ", tableNo=" + tableNo + ", slotTime=" + slotTime + ", orderItems=" + orderItems + ", orderedDate="
				+ orderedDate + ", amount=" + amount + ", paymentmode=" + paymentmode + ", paymentstatus="
				+ paymentstatus + ", staffId=" + staffId + ", status=" + status + "]";
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

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getReservationId() {
		return reservationId;
	}

	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}

	public String getTableNo() {
		return tableNo;
	}

	public void setTableNo(String tableNo) {
		this.tableNo = tableNo;
	}

	public String getSlotTime() {
		return slotTime;
	}

	public void setSlotTime(String slotTime) {
		this.slotTime = slotTime;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public String getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(String orderedDate) {
		this.orderedDate = orderedDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaymentmode() {
		return paymentmode;
	}

	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}

	public String getPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

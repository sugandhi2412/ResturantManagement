package com.dinein.model;

import org.springframework.data.annotation.Id;

public class ReservationAmount {
	
	@Id
	String id;
	String customerId;
	int roomNo;
	String checkInDate;
	String checkOutDate;
	int numberOfOccupants;
	String employeeId;
	String type;
	String bookingDate;
	String status;
	double chargeAmount;
	double dueAmount;
	double amountPaid;
	String paymentType;
	public ReservationAmount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReservationAmount(String id, String customerId, int roomNo, String checkInDate, String checkOutDate,
			int numberOfOccupants, String employeeId, String type, String bookingDate, String status,
			double chargeAmount, double dueAmount, double amountPaid, String paymentType) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.roomNo = roomNo;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.numberOfOccupants = numberOfOccupants;
		this.employeeId = employeeId;
		this.type = type;
		this.bookingDate = bookingDate;
		this.status = status;
		this.chargeAmount = chargeAmount;
		this.dueAmount = dueAmount;
		this.amountPaid = amountPaid;
		this.paymentType = paymentType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public int getNumberOfOccupants() {
		return numberOfOccupants;
	}
	public void setNumberOfOccupants(int numberOfOccupants) {
		this.numberOfOccupants = numberOfOccupants;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getChargeAmount() {
		return chargeAmount;
	}
	public void setChargeAmount(double chargeAmount) {
		this.chargeAmount = chargeAmount;
	}
	public double getDueAmount() {
		return dueAmount;
	}
	public void setDueAmount(double dueAmount) {
		this.dueAmount = dueAmount;
	}
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	@Override
	public String toString() {
		return "ReservationAmount [id=" + id + ", customerId=" + customerId + ", roomNo=" + roomNo + ", checkInDate="
				+ checkInDate + ", checkOutDate=" + checkOutDate + ", numberOfOccupants=" + numberOfOccupants
				+ ", employeeId=" + employeeId + ", type=" + type + ", bookingDate=" + bookingDate + ", status="
				+ status + ", chargeAmount=" + chargeAmount + ", dueAmount=" + dueAmount + ", amountPaid=" + amountPaid
				+ ", paymentType=" + paymentType + "]";
	}
	
	
}

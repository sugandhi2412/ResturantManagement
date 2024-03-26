package com.dinein.model;

public class Booking {

	String bdate;
	int capacity;
	String slotTime;
	public Booking(String bdate, int capacity, String slotTime) {
		super();
		this.bdate = bdate;
		this.capacity = capacity;
		this.slotTime = slotTime;
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Booking [bdate=" + bdate + ", capacity=" + capacity + ", slotTime=" + slotTime + "]";
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getSlotTime() {
		return slotTime;
	}
	public void setSlotTime(String slotTime) {
		this.slotTime = slotTime;
	}
	

	
}

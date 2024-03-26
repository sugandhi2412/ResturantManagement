package com.dinein.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "slot")
public class Slot {
	
	@Id
	String id;
	String slotTime;

	
	public Slot() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Slot(String id, String slotTime) {
		super();
		this.id = id;
		this.slotTime = slotTime;
	}


	@Override
	public String toString() {
		return "Slot [id=" + id + ", slotTime=" + slotTime + "]";
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getSlotTime() {
		return slotTime;
	}


	public void setSlotTime(String slotTime) {
		this.slotTime = slotTime;
	}

	
}

package com.dinein.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "table")
public class Table {
	
	@Id
	String id;
	int tableNo;
	int capacity;

	
	public Table() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Table(String id, int tableNo, int capacity) {
		super();
		this.id = id;
		this.tableNo = tableNo;
		this.capacity = capacity;
	}


	@Override
	public String toString() {
		return "Table [id=" + id + ", tableNo=" + tableNo + ", capacity=" + capacity + "]";
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getTableNo() {
		return tableNo;
	}


	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}


	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	
}

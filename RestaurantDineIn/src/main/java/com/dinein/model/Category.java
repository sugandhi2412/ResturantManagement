package com.dinein.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "category")
public class Category {
	
	@Id
	String id;
	String catId;
	String name;
	String remarks;

	public Category() {
		super();
	}

	public Category(String id) {
		super();
		this.id = id;
	}

	public Category(String id, String catId, String name, String remarks) {
		super();
		this.id = id;
		this.catId = catId;
		this.name = name;
		this.remarks = remarks;
	}
	
	public Category(String catId, String name, String remarks) {
		super();
		this.catId = catId;
		this.name = name;
		this.remarks = remarks;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCatId() {
		return catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ",catId=" + catId + ", name=" + name + ", remarks=" + remarks + "]";
	}
	
	
	
}

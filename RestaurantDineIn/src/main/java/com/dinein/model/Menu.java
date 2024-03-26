package com.dinein.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "menu")
public class Menu {
	
	@Id
	String id;
	String menuId;
	String catId;
	String name;
	double price;
	String recipe;
	String imgUrl;

	
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Menu(String id, String menuId, String catId, String name, double price, String recipe, String imgUrl) {
		super();
		this.id = id;
		this.menuId = menuId;
		this.catId = catId;
		this.name = name;
		this.price = price;
		this.recipe = recipe;
		this.imgUrl = imgUrl;
	}


	public Menu(String menuId, String catId, String name, double price, String recipe, String imgUrl) {
		super();
		this.menuId = menuId;
		this.catId = catId;
		this.name = name;
		this.price = price;
		this.recipe = recipe;
		this.imgUrl = imgUrl;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getMenuId() {
		return menuId;
	}


	public void setMenuId(String menuId) {
		this.menuId = menuId;
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


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getRecipe() {
		return recipe;
	}


	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	@Override
	public String toString() {
		return "Menu [id=" + id + ", menuId=" + menuId + ", catId=" + catId + ", name=" + name +", price=" + price
				+ ", recipe=" + recipe + ", imgUrl=" + imgUrl + "]";
	}

	
	
}

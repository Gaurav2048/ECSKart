package com.iitg.ecommerce.Shop.models;

import java.io.Serializable;

public class Cart implements Serializable {

	String id ; 
	String name; 
	int price; 
	int rate; 
	int quantity; 
	String image;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}
	
	public Cart(String id, String name, int price,int rate,  int quantity, String image) {
		super();
		this.id = id;
		this.name = name;
		this.rate = rate; 
		this.quantity = quantity; 
		this.price = price;
		this.image = image;
	}

	
	
	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	} 
	
	
	
	
	
	
}

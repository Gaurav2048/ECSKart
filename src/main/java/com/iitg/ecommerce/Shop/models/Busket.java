package com.iitg.ecommerce.Shop.models;

import java.io.Serializable;
import java.util.List;

public class Busket implements Serializable {
	List<Cart> busket;

	public List<Cart> getBusket() {
		return busket;
	}

	public void setBusket(List<Cart> busket) {
		this.busket = busket;
	}

	public Busket(List<Cart> busket) {
		super();
		this.busket = busket;
	} 
	
	
	 public Busket() {
		// TODO Auto-generated constructor stub
	}
}

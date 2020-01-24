package com.iitg.ecommerce.Shop.models;

import java.util.List;

public class Home {
	
	private List<Product> featuredItems; 
	private List<Product> recommandedList;
	
	public Home(List<Product> featuredItems, List<Product> recommandedList) {
		super();
		this.featuredItems = featuredItems;
		this.recommandedList = recommandedList;
	}
	
	public List<Product> getFeaturedItems() {
		return featuredItems;
	}
	public void setFeaturedItems(List<Product> featuredItems) {
		this.featuredItems = featuredItems;
	}
	public List<Product> getRecommandedList() {
		return recommandedList;
	}
	public void setRecommandedList(List<Product> recommandedList) {
		this.recommandedList = recommandedList;
	} 
	
	
	
	
}

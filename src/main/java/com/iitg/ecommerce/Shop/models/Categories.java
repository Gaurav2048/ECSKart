package com.iitg.ecommerce.Shop.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@Table(name="categories")
public class Categories {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	int category_id;
	@Column
	String category_name;
	
	@Transient
	List<SubCategories> subcatList; 
	
	@Override
	public String toString() {
		return "Categories [category_id=" + category_id + ", category_name=" + category_name + "]";
	}
	
	public List<SubCategories> getSubcatList() {
		return subcatList;
	}

	public void setSubcatList(List<SubCategories> subcatList) {
		this.subcatList = subcatList;
	}

	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	} 
}

package com.iitg.ecommerce.Shop.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "sub_category")
public class SubCategories {
   
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	int sub_cat_id; 
	@Column
	int category_id; 
	@Column
	String sub_cat_name;
	@Transient
	List<FloorCategory> fList;
	
	
	
	@Override
	public String toString() {
		return "SubCategories [sub_cat_id=" + sub_cat_id + ", category_id=" + category_id + ", sub_cat_name="
				+ sub_cat_name + ", fList=" + fList + "]";
	}

	public List<FloorCategory> getfList() {
		return fList;
	}

	public void setfList(List<FloorCategory> fList) {
		this.fList = fList;
	}

	public int getSub_cat_id() {
		return sub_cat_id;
	}
	public void setSub_cat_id(int sub_cat_id) {
		this.sub_cat_id = sub_cat_id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getSub_cat_name() {
		return sub_cat_name;
	}
	public void setSub_cat_name(String sub_cat_name) {
		this.sub_cat_name = sub_cat_name;
	} 
	
	
	
}

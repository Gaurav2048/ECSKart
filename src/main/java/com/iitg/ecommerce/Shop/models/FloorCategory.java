package com.iitg.ecommerce.Shop.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "floor_category")
public class FloorCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	String id;
	@Column
	String floor_category_name;
	@Column
	int sub_category_id;
	
	
	
	public FloorCategory() {
		super();
	}

	public FloorCategory(String id, String floor_category_name, int sub_category_id) {
		super();
		this.id = id;
		this.floor_category_name = floor_category_name;
		this.sub_category_id = sub_category_id;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFloor_category_name() {
		return floor_category_name;
	}
	public void setFloor_category_name(String floor_category_name) {
		this.floor_category_name = floor_category_name;
	}
	public int getSub_category_id() {
		return sub_category_id;
	}
	public void setSub_category_id(int sub_category_id) {
		this.sub_category_id = sub_category_id;
	} 
	
	
	
}

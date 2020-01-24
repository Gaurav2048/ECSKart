package com.iitg.ecommerce.Shop.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int product_id;
	@Column
	String product_name;
	@Column
	String description;
	@Column
	double price;
	@Column
	int discount;
	@Column
	int available;
	@Column
	int onsale;
	@Column
	int cat_id;
	@Column
	int sub_cat_id;
	@Column 
	int floor_cat_id; 
	@Column
	String image;
	@Transient
	String cat_name; 
	@Transient
	String sub_cat_name; 
	@Transient
	String inner_cat_name; 
	
	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	public String getSub_cat_name() {
		return sub_cat_name;
	}

	public void setSub_cat_name(String sub_cat_name) {
		this.sub_cat_name = sub_cat_name;
	}

	public String getInner_cat_name() {
		return inner_cat_name;
	}

	public void setInner_cat_name(String inner_cat_name) {
		this.inner_cat_name = inner_cat_name;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", description=" + description
				+ ", price=" + price + ", discount=" + discount + ", available=" + available + ", onsale=" + onsale
				+ ", cat_id=" + cat_id + ", sub_cat_id=" + sub_cat_id + ", image=" + image + "]";
	}
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getAvailable() {
		return available;
	}
	public int getFloor_cat_id() {
		return floor_cat_id;
	}

	public void setFloor_cat_id(int floor_cat_id) {
		this.floor_cat_id = floor_cat_id;
	}

	public void setAvailable(int available) {
		this.available = available;
	}
	public int getOnsale() {
		return onsale;
	}
	public void setOnsale(int onsale) {
		this.onsale = onsale;
	}
	public int getCat_id() {
		return cat_id;
	}
	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}
	public int getSub_cat_id() {
		return sub_cat_id;
	}
	public void setSub_cat_id(int sub_cat_id) {
		this.sub_cat_id = sub_cat_id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	} 
}

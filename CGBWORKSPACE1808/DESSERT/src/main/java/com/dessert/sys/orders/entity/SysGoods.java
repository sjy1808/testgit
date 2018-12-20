package com.dessert.sys.orders.entity;

import java.io.Serializable;

public class SysGoods implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Double price;//单价
	private String category;//商品类型
	private String image;
	//private String imagepath;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "SysGoods [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + ", image="
				+ image + "]";
	}
	
	
	
	
}

package com.tedu.jt.web;

/**
 * 商品信息类,用来封装所有的商品信息
 */
public class Product {
	//1.声明属性用于保存商品信息
	private int id;
	private String name;
	private String category;
	private double price;
	private int pnum;
	private String description;
	//2.提供无参构造函数
	public Product() {
		super();
	}
	//3.提供有参构造函数
	public Product(int id, String name, String category, double price, int pnum, String description) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.pnum = pnum;
		this.description = description;
	}
	//4.提供属性对应的get和set方法
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	//5.覆盖toString方法
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", pnum=" + pnum
				+ ", description=" + description + "]";
	}
	
	
	
}

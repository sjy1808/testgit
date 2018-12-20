package com.dessert.sys.orders.entity;

import java.io.Serializable;
import java.util.Date;

public class Orders implements Serializable{
	private static final long serialVersionUID = 6323739628778739008L;
	private Integer id;
	private String username;
	//订单号
	private String number;
	private Date createdTime;
	//数量
	private Integer count;
	private Double price;
	private Double money;
	private String address;
	private String note;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", username=" + username + ", number=" + number + ", createdTime=" + createdTime
				+ ", count=" + count + ", price=" + price + ", money=" + money + ", address=" + address + ", note="
				+ note + "]";
	}	
}
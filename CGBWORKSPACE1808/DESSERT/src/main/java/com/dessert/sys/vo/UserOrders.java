package com.dessert.sys.vo;

import java.io.Serializable;

import com.dessert.sys.orders.entity.Orders;
import com.dessert.sys.orders.entity.User;

public class UserOrders implements Serializable{
	private static final long serialVersionUID = 342459310389708497L;
	private Integer id;
	private Integer user_id;
	private Integer orders_id;
	private User user;
	private Orders orders;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getOrders_id() {
		return orders_id;
	}
	public void setOrders_id(Integer orders_id) {
		this.orders_id = orders_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "UserOrders [id=" + id + ", user_id=" + user_id + ", orders_id=" + orders_id + ", user=" + user
				+ ", orders=" + orders + "]";
	}
	
}
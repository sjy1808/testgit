package com.jt.common.vo;

import java.io.Serializable;
/**
 * Vo:封装只有id和name的角色信息
 * @author Administrator
 *
 */
public class CheckBox implements Serializable {

	private static final long serialVersionUID = -224148797542502698L;
	private Integer id;
	private String name;
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
	@Override
	public String toString() {
		return "CheckBox [id=" + id + ", name=" + name + "]";
	}
	
}

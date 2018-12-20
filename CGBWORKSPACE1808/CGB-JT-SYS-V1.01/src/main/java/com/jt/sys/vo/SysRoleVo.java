package com.jt.sys.vo;

import java.io.Serializable;
import java.util.List;
/**
 * 定义值对象(Vo):借助此对象封装角色修改时
 * 从数据库获取的角色以及角色的相关信息
 * @author Administrator
 *
 */
public class SysRoleVo implements Serializable {

	private static final long serialVersionUID = -48491083382607667L;
	private Integer id;//角色id
	private String name;//角色name
	private String note;//角色信息
	private List<Integer> menuIds;//菜单id
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
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public List<Integer> getMenuIds() {
		return menuIds;
	}
	public void setMenuIds(List<Integer> menuIds) {
		this.menuIds = menuIds;
	}
	
}

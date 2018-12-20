package com.dessert.sys.entity;

import java.io.Serializable;
import java.util.Date;

public class SysDept implements Serializable {

	private static final long serialVersionUID = -4968414909875942379L;
	private int id;
	private String name;
	private int parentId;
	private int sort;
	private String note;
	private Date createdTime;
	private Date modifiedTime;
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
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	@Override
	public String toString() {
		return "SysDept [id=" + id + ", name=" + name + ", parentId=" + parentId + ", sort=" + sort + ", note=" + note
				+ ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime + "]";
	}
	
	
	
}

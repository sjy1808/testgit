package com.jt.common.po;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="tb_item_cat")
public class ItemCat extends BasePojo {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long parentId;	//父级Id
	private String name;	//商品分类的名称
	private Integer status;	//商品状态信息
	private Integer sortOrder;	//排序号
	private Boolean isParent;	//是否为父级
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	public Boolean getIsParent() {
		return isParent;
	}
	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}
	@Override
	public String toString() {
		return "ItemCat [id=" + id + ", parentId=" + parentId + ", name=" + name + ", status=" + status + ", sortOrder="
				+ sortOrder + ", isParent=" + isParent + "]";
	}
	
	
}

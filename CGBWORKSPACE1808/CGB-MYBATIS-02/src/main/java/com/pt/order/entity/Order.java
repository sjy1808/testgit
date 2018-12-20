package com.pt.order.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * POJO对象类
 * 订单实体类
 */
public class Order implements Serializable{

	private static final long serialVersionUID = 8552549819404782325L;
	private Integer id;
	private String code;
	private Integer memberId;
	private Integer goodsId;
	private Float totalprice;
	private Integer status;
	private String remark;
	private Date createdTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Float getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Float totalprice) {
		this.totalprice = totalprice;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", code=" + code + ", memberId=" + memberId + ", goodsId=" + goodsId
				+ ", totalprice=" + totalprice + ", status=" + status + ", remark=" + remark + ", createdTime="
				+ createdTime + "]";
	}
	

}
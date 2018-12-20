package com.pt.order.vo;

import java.io.Serializable;
import java.util.Date;

import com.pt.member.entity.Member;
/**
 * VO类
 *
 */
public class OrderVo implements Serializable {

	
	private static final long serialVersionUID = -746573756446117013L;
	/**物理id*/
	private Integer id;
	/**业务id*/
	private String code;
	/**商品id*/
	private Integer goodsId;
	/**订单总价*/
	private Float totalPrice;
	/**订单状态*/
	private Integer status;
	/**订单备注*/
	private String remark;
	/**订单创建时间*/
	private Date createdTime;
	/**订单所属会员  借助此属性来封装会员信息*/
	private Member member;
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
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
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
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	@Override
	public String toString() {
		return "OrderVo [id=" + id + ", code=" + code + ", goodsId=" + goodsId + ", totalPrice=" + totalPrice
				+ ", status=" + status + ", remark=" + remark + ", createdTime=" + createdTime + ", member=" + member
				+ "]";
	}
	

}

package com.jt.common.po;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="tb_item_desc")
public class ItemDesc extends BasePojo {

	@Id //表示主键
	private Long itemId; //定义商品id
	private String itemDesc;//定义商品详情
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	@Override
	public String toString() {
		return "ItemDesc [itemId=" + itemId + ", itemDesc=" + itemDesc + "]";
	}
	
}

package com.jt.search.pojo;

import org.apache.solr.client.solrj.beans.Field;

import com.jt.common.po.BasePojo;
//实体类对应的是solr中的jt数据
public class Item extends BasePojo{

	//solr有个jt core,每个数据有id field title field
	@Field("id")
	private Long id;
	
	@Field("title")
	private String title;
	
	@Field("sellPoint")
	private String sellPoint;
	
	@Field("price")
	private Long price;
	
	//jsp foreach item  item.image/item.images
	//solr中filed的name是image
	@Field("image")
	private String images;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSellPoint() {
		return sellPoint;
	}

	public void setSellPoint(String sellPoint) {
		this.sellPoint = sellPoint;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	//jsp item.images
	public String[] getImages() {
		//1.png,2.png img src=1.png,2.png
		return images.split(",");
	}

	public void setImages(String images) {
		this.images = images;
	}
	
	

}

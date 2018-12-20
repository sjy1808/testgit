package com.jt.manage.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.po.Item;
import com.jt.common.po.ItemDesc;
import com.jt.common.vo.EasyUIResult;
import com.jt.manage.mapper.ItemDescMapper;
import com.jt.manage.mapper.ItemMapper;
import com.jt.manage.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private ItemDescMapper itemDescMapper;
	//实现商品的查询
	@Override
	public EasyUIResult findItemByPage(Integer page, Integer rows) {
		//1.获取商品记录的总数
		//int total=itemMapper.findItemCount();
		int total=itemMapper.selectCount(null);
		//2.获取商品列表信息,使用分页
		int start =(page-1)*rows;
		List<Item> itemList=itemMapper.findItemByPage(start,rows);
		return new EasyUIResult(total,itemList);
	}
	@Override
	public String findItemCateNameById(Long itemId) {
		return itemMapper.findItemCateNameById(itemId);
	}
	@Override
	public void saveItem(Item item,String desc) {
		//补全数据
		//同时入库两张表
		item.setStatus(1);//1.上架状态 2.下架
		item.setCreated(new Date());
		item.setUpdated(item.getCreated());
		itemMapper.insert(item);//新增完成后一定有id
		/**
		 * 通用Mapper动态获取主键
		 * Executing:SELECE LAST_INSERT_ID()
		 */
		ItemDesc itemDesc = new ItemDesc();
		itemDesc.setItemId(item.getId());
		itemDesc.setItemDesc(desc);
		itemDescMapper.insert(itemDesc);
	}
	@Override
	public void updateItem(Item item,String desc) {
		item.setStatus(1);
		item.setUpdated(new Date());
		itemMapper.updateByPrimaryKeySelective(item);
		
		ItemDesc itemDesc = new ItemDesc();
		itemDesc.setItemId(item.getId());
		itemDesc.setItemDesc(desc);
		itemDesc.setUpdated(item.getUpdated());
		itemDescMapper.updateByPrimaryKeySelective(itemDesc);
	}
	@Override
	public void updateStatus(Long[] ids, int status) {
		itemMapper.updateStatus(ids,status);
	}
	@Override
	public void deleteItem(Long[] ids) {
		itemMapper.deleteByIDS(ids);
	}
	@Override
	public ItemDesc findItemDescById(Long itemId) {
		return itemDescMapper.selectByPrimaryKey(itemId);
	}
	@Override
	public Item findItemById(Long itemId) {
		return itemMapper.selectByPrimaryKey(itemId);
	}

}

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
	//实现商品查询
	@Override
	public EasyUIResult findItemByPage(Integer page, Integer rows) {
		//1.获取商品记录总数
		//int total=itemMapper.findItemCount();
		int total=itemMapper.selectCount(null);
		//2.获取商品列表信息使用分页
		int start=(page-1)*rows;
		List<Item> itemList=itemMapper.findItemByPage(start,rows);
		return new EasyUIResult(total,itemList);
	}
	@Override
	public String findItemCatNameById(Long itemId) {
		return itemMapper.findItemCatNameById(itemId);
	}
	@Override
	public void saveItem(Item item,String desc) {
		//补全数据
		item.setCreated(new Date());
		item.setUpdated(new Date());
		item.setStatus(1);//1.上架,2.下架
		itemMapper.insert(item);
		
		ItemDesc itemDesc = new ItemDesc();
		itemDesc.setItemId(item.getId());
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(item.getCreated());
		itemDesc.setUpdated(item.getUpdated());
		System.out.println(itemDescMapper.insert(itemDesc));
	}
	@Override
	public void updateItem(Item item, String desc) {
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
	public ItemDesc findItemDescById(Long itemId) {
		
		System.out.println(itemId);
		
		return itemDescMapper.selectByPrimaryKey(itemId);
	}
	//实现商品的上下架
	@Override
	public void updateStatus(Long[] ids, int status) {
		itemMapper.updateStatus(ids, status);
	}
	@Override
	public void deleteItem(Long[] ids) {
		itemMapper.deleteByIDS(ids);
	}
	@Override
	public Item findItemById(Long itemId) {
		return itemMapper.selectByPrimaryKey(itemId);
	}

}

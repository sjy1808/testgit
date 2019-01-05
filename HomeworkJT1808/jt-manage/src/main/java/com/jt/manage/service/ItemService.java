package com.jt.manage.service;

import com.jt.common.po.Item;
import com.jt.common.po.ItemDesc;
import com.jt.common.vo.EasyUIResult;

public interface ItemService {

	EasyUIResult findItemByPage(Integer page, Integer rows);

	String findItemCatNameById(Long itemId);

	void saveItem(Item item, String desc);

	void updateItem(Item item, String desc);

	ItemDesc findItemDescById(Long itemId);

	void updateStatus(Long[] ids, int status);

	void deleteItem(Long[] ids);

	Item findItemById(Long itemId);

	
}

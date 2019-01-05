package com.jt.manage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.po.ItemCat;
import com.jt.manage.mapper.ItemCatMapper;
import com.jt.manage.service.ItemCatService;
import com.jt.manage.vo.EasyUITree;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private ItemCatMapper itemCatMapper;

	@Override
	public List<EasyUITree> findItemCatList(Long parentId) {
		//根据parentId查询商品分类列表信息
		ItemCat itemCatTemp = new ItemCat();
		itemCatTemp.setParentId(parentId);
		List<ItemCat> itemCatList=itemCatMapper.select(itemCatTemp);
		//准备返回值数据
		List<EasyUITree> treeList=new ArrayList<>();
		for (ItemCat itemCat : itemCatList) {
			EasyUITree easyUITree = new EasyUITree();
			easyUITree.setId(itemCat.getId());
			easyUITree.setText(itemCat.getName());//商品分类的名称
			//如果为父级则写closed如果不是父级open
			String state=itemCat.getIsParent()?"closed":"open";
			easyUITree.setState(state);
			treeList.add(easyUITree);
		}
		return treeList;
	}
	
	
}

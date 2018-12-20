package com.jt.manage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.common.po.ItemCat;
import com.jt.common.service.RedisService;
import com.jt.manage.mapper.ItemCatMapper;
import com.jt.manage.service.ItemCatService;
import com.jt.manage.vo.EasyUITree;

import redis.clients.jedis.JedisCluster;

//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.ShardedJedisPool;

@Service
public class ItemCatServiceImpl implements ItemCatService {
	
	@Autowired
	private ItemCatMapper itemCatMapper;
	/*@Autowired
	private Jedis jedis;*/
	/*@Autowired
	private RedisService redisService;*/
	@Autowired
	private JedisCluster jedisCluster;
	
	private static ObjectMapper objectMapper=new ObjectMapper();

	/**
	 * 1.要什么? List<EasyUITree>
	 * 2.业务是什么? 查询商品分类列表信息 List<ItemCat>
	 * 3.怎么做?? 循环遍历
	 */
	@Override
	public List<EasyUITree> findItemCatList(Long parentId) {
		//根据parentId查询商品分类信息
		ItemCat itemCatTemp = new ItemCat();
		itemCatTemp.setParentId(parentId);
		List<ItemCat> itemCatList = itemCatMapper.select(itemCatTemp);
		//准备返回值数据
		List<EasyUITree> treeList = new ArrayList<>();
		for(ItemCat itemCat : itemCatList){
			EasyUITree easyUITree = new EasyUITree();
			easyUITree.setId(itemCat.getId());
			easyUITree.setText(itemCat.getName());//商品分类的名称
			//如果为父级则写closed,如果不是父级open
			String state=itemCat.getIsParent()?"closed":"open";
			easyUITree.setState(state);
			treeList.add(easyUITree);
		}
		return treeList;
	}
	
	/**
	 * 添加缓存机制
	 * 1.用户首先查询缓存
	 * 		没数据:则查询数据库,将查询的结果转化为JSON串,将数据保存到redis中,之后数据返回
	 * 		有数据:将JSON串转换为java对象,之后返回数据
	 * 	objectMapper  API 
	 * 		1.在业务层将查询的结果转化为JSON串
	 * 		2.将JSON串转换为java对象
	 * 
	 */

	/*@Override
	public List<EasyUITree> findCatchList(Long parentId) {
		String key="ITEM_CAT_"+parentId;
		String resultJSON=jedis.get(key);
		List<EasyUITree> treeList=new ArrayList<>();
		try {
			if(StringUtils.isEmpty(resultJSON)){
				//查询数据库获取数据
				treeList=findItemCatList(parentId);
				String jsonData=objectMapper.writeValueAsString(treeList);
				jedis.set(key, jsonData);
				System.out.println("第一次查询");
			}else{
				treeList=objectMapper.readValue(resultJSON, treeList.getClass());
				System.out.println("第二次查询");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return treeList;
	}*/
	
	//通过程序连接redis分片
	@Override
	public List<EasyUITree> findCatchList(Long parentId) {
		String key="ITEM_CAT_"+parentId;
		String resultJSON=jedisCluster.get(key);
		List<EasyUITree> treeList=new ArrayList<>();
		try {
			if(StringUtils.isEmpty(resultJSON)){
				//查询数据库获取数据
				treeList=findItemCatList(parentId);
				String jsonData=objectMapper.writeValueAsString(treeList);
				jedisCluster.set(key, jsonData);
				System.out.println("第一次查询");
			}else{
				treeList=objectMapper.readValue(resultJSON, treeList.getClass());
				System.out.println("第二次查询");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return treeList;
	}
}

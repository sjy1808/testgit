package com.dessert.sys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.dessert.common.vo.PageObject;
import com.dessert.exception.ServiceException;
import com.dessert.sys.dao.SysGoodsDao;
import com.dessert.sys.orders.entity.SysGoods;
import com.dessert.sys.service.GoodsService;
@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private SysGoodsDao sysGoodsDao;

	@Override
	public PageObject<SysGoods> findPageObjects(String name, Integer pageCurrent) {
		if(pageCurrent==null||pageCurrent<1){
			throw new ServiceException("当前页码不正确");
		}
		int rowCount = sysGoodsDao.getRowCount(name);
		if(rowCount==0){
			throw new ServiceException("记录不存在");
		}
		int pageSize=4;
		int startIndex=(pageCurrent-1)*pageSize;
		int pageCount=rowCount/pageSize;
		if(rowCount%pageSize!=0){
			pageCount++;
		}
		List<SysGoods> goods = sysGoodsDao.findPageObjects(name, startIndex, pageSize);
		PageObject<SysGoods> p = new PageObject<>();
		p.setRecords(goods);
		p.setPageCount(pageCount);
		p.setPageCurrent(pageCurrent);
		p.setPageSize(pageSize);
		p.setRowCount(rowCount);
		return p;
	}

	@Override
	public int deleteObject(Integer id) {
		if(id==null||id<1){
			throw new ServiceException("id的值不正确");
		}
		int rows = sysGoodsDao.deleteGoods(id);
		if(rows==0){
			throw new ServiceException("订单可能已经不存在");
		}
		
		return rows;
	}

	@Override
	public int saveObject(SysGoods entity) {
		System.out.println(entity);
		if(entity==null){
			throw new ServiceException("商品数据不能为空");
		}
		if(StringUtils.isEmpty(entity.getName())){
			throw new ServiceException("商品名不能为空");
		}
		
		
		int rows = sysGoodsDao.insertObject(entity);
		
		
		
		
		return rows;
	}

	@Override
	public Map<String, Object> findObjectById(Integer id) {
		if(id==null||id<0){
			throw new ServiceException("id的值不合法");
		}
		SysGoods goods = sysGoodsDao.findObjectById(id);
		if(goods==null){
			throw new ServiceException("此记录不存在");
		}
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("goods", goods);
		return map;
	}

	@Override
	public int updateObject(SysGoods entity) {
		if(entity==null){
			throw new ServiceException("更新对象不能为空");
		}
		if(entity.getId()==null){
			throw new ServiceException("id的值不能为空");
		}
		if(StringUtils.isEmpty(entity.getName())){
			throw new ServiceException("商品名不能为空");
		}
		if(StringUtils.isEmpty(entity.getImage())){
			throw new ServiceException("商品图片地址不能为空");
		}
		//正整数：^[1-9]\d?$   小数：^([0-9])|([1-9]\d+)\.\d?$
		
		
		int rows = sysGoodsDao.updateObject(entity);
		if(rows==0){
			throw new ServiceException("对象可能不存在");
		}
		
		return rows;
	}

	@Override
	public PageObject<SysGoods> findPageObjectsCategory(String category) {
		 
		/*int rowCount = sysGoodsDao.getRowCount(category);
		if(rowCount==0){
			throw new ServiceException("记录不存在");
		}*/
		//int pageSize=3;
		//int startIndex=(pageCurrent-1)*pageSize;
		/*int pageCount=rowCount/pageSize;
		if(rowCount%pageSize!=0){
			pageCount++;
		}*/
		List<SysGoods> goods = sysGoodsDao.findPageObjectsByCategory(category);
		PageObject<SysGoods> p = new PageObject<>();
		p.setRecords(goods);
		//p.setPageCount(pageCount);
		//p.setPageCurrent(pageCurrent);
	//	p.setPageSize(pageSize);
		//p.setRowCount(rowCount);
		return p;
	}
	
	
	
	
	

}

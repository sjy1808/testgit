package com.dessert.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.dessert.common.exception.ServiceException;
import com.dessert.common.vo.PageObject;
import com.dessert.sys.dao.SysEmployeeDao;
import com.dessert.sys.entity.SysEmployee;
import com.dessert.sys.service.SysEmployeeService;
@Service
public class SysEmployeeServiceImpl implements SysEmployeeService {

	@Autowired
	private SysEmployeeDao sysEmployeeDao;
	@Override
	public PageObject<SysEmployee> findPageObjects(String name, Integer pageCurrent) {
		if(pageCurrent==null||pageCurrent<1)throw new IllegalArgumentException("当前页码不正确");
		int rowCount=sysEmployeeDao.getRowCount(name);
		if(rowCount==0)throw new ServiceException("系统没有查询到对应记录");
		int pageSize=4;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysEmployee> records=sysEmployeeDao.findPageObjects(name, startIndex, pageSize);
		PageObject<SysEmployee> pageObject = new PageObject<>();
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setRowCount(rowCount);
		pageObject.setRecords(records);
		pageObject.setPageCount((rowCount-1)/pageSize+1);
		return pageObject;
	}
	@Override
	public int saveObject(SysEmployee entity) {
		if(entity==null)throw new ServiceException("保存对象不能为空");
		//if(StringUtils.isEmpty(entity.getGender()))throw new ServiceException("性别不能为空");
		if(StringUtils.isEmpty(entity.getName()))throw new ServiceException("名字不能为空");
		//if(StringUtils.isEmpty(entity.getRole()))throw new ServiceException("职位不能为空");
		if(StringUtils.isEmpty(entity.getPhone()))throw new ServiceException("电话不能为空");
		if(StringUtils.isEmpty(entity.getEmail()))throw new ServiceException("email不能为空");
		//if(StringUtils.isEmpty(entity.getAdress()))throw new ServiceException("地址不能为空");
		//if(entity.getHiredate()==null)throw new ServiceException("入职时间不能为空");
		int rows;
		try {
			rows=sysEmployeeDao.insertObject(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("保存失败");
		}
		return rows;
	}
	@Override
	public int deleteObject(Integer id) {
		if(id==null||id<1)throw new IllegalArgumentException("请先选择要删除的员工信息");
		int rows;
		try {
			rows=sysEmployeeDao.deleteObject(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("删除失败!");
		}
		return rows;
	}
	@Override
	public int updateObject(SysEmployee entity) {
		if(entity==null)throw new ServiceException("保存的对象为空");
		if(StringUtils.isEmpty(entity.getGender()))throw new ServiceException("性别不能为空");
		if(StringUtils.isEmpty(entity.getName()))throw new ServiceException("名字不能为空");
		if(StringUtils.isEmpty(entity.getRole()))throw new ServiceException("职位不能为空");
		if(StringUtils.isEmpty(entity.getPhone()))throw new ServiceException("电话不能为空");
		if(StringUtils.isEmpty(entity.getEmail()))throw new ServiceException("email不能为空");
		if(StringUtils.isEmpty(entity.getAdress()))throw new ServiceException("地址不能为空");
		if(entity.getHiredate()==null)throw new ServiceException("入职时间不能为空");
		int rows;
		try {
			rows=sysEmployeeDao.updateObject(entity);
			System.out.println(rows);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("更新失败");
		}
		return rows;
	}
	@Override
	public List<SysEmployee> findObjectById(Integer id) {
		if(id==null||id<1)throw new IllegalArgumentException("请先选择!");
		List<SysEmployee> object = sysEmployeeDao.findObjectById(id);
		return object;
	}

}

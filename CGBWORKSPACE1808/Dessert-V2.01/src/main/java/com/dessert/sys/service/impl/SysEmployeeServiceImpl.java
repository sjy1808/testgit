package com.dessert.sys.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.dessert.common.exception.ServiceException;
import com.dessert.common.vo.PageObject;
import com.dessert.sys.dao.SysEmployeeDao;
import com.dessert.sys.entity.SysEmployee;
import com.dessert.sys.service.SysEmployeeService;
import com.dessert.sys.vo.SysEmployeeDeptResult;

@Service
public class SysEmployeeServiceImpl implements SysEmployeeService {

	@Autowired
	private SysEmployeeDao sysEmployeeDao;

	@Override
	public PageObject<SysEmployeeDeptResult> findPageObjects(String name, Integer pageCurrent) {
		//1.数据合法性验证
				if(pageCurrent==null||pageCurrent<=0)
				throw new ServiceException("参数不合法");
		//2.依据条件获取总记录数
				int rowCount=sysEmployeeDao.getRowCount(name);
		        if(rowCount==0)
				throw new ServiceException("记录不存在");
				//3.计算startIndex的值
				int pageSize=4;
				int startIndex=(pageCurrent-1)*pageSize;
				//4.依据条件获取当前页数据
				List<SysEmployeeDeptResult> records=
					sysEmployeeDao.findPageObjects(
				name, startIndex, pageSize);
				//5.封装数据
				PageObject<SysEmployeeDeptResult> pageObject=new PageObject<>();
				pageObject.setPageCurrent(pageCurrent);
				pageObject.setRowCount(rowCount);
				pageObject.setPageSize(pageSize);
				pageObject.setRecords(records);
				pageObject.setPageCount((rowCount-1)/pageSize+1);
				return pageObject;

	}

	@Override
	public int saveObject(SysEmployee entity) {
		if (entity == null)
			throw new ServiceException("保存对象不能为空");
		// if(StringUtils.isEmpty(entity.getGender()))throw new
		// ServiceException("性别不能为空");
		if (StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("名字不能为空");
		// if(StringUtils.isEmpty(entity.getRole()))throw new
		// ServiceException("职位不能为空");
		if (StringUtils.isEmpty(entity.getPhone()))
			throw new ServiceException("电话不能为空");
		if (StringUtils.isEmpty(entity.getEmail()))
			throw new ServiceException("email不能为空");
		// if(StringUtils.isEmpty(entity.getAdress()))throw new
		// ServiceException("地址不能为空");
		// if(entity.getHiredate()==null)throw new ServiceException("入职时间不能为空");
		String salt = UUID.randomUUID().toString();// 借助随机字符串
		entity.setSalt(salt);
		// 对密码进行加密
		SimpleHash sHash = new SimpleHash("MD5", // 加密算法
				entity.getPassword(), salt);
		//System.out.println("entity.getPassword="+entity.getPassword());
		entity.setPassword(sHash.toString());
		int rows;
		try {
			rows = sysEmployeeDao.insertObject(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("保存失败");
		}
		return rows;
	}

	@Override
	public int deleteObject(Integer id) {
		if (id == null || id < 1)
			throw new IllegalArgumentException("请先选择要删除的员工信息");
		int rows;
		try {
			rows = sysEmployeeDao.deleteObject(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("删除失败!");
		}
		return rows;
	}

	@Override
	public int updateObject(SysEmployee entity) {
		if (entity == null)
			throw new ServiceException("保存的对象为空");
		if (StringUtils.isEmpty(entity.getGender()))
			throw new ServiceException("性别不能为空");
		if (StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("名字不能为空");
		if (StringUtils.isEmpty(entity.getRole()))
			throw new ServiceException("职位不能为空");
		if (StringUtils.isEmpty(entity.getPhone()))
			throw new ServiceException("电话不能为空");
		if (StringUtils.isEmpty(entity.getEmail()))
			throw new ServiceException("email不能为空");
		if (StringUtils.isEmpty(entity.getAdress()))
			throw new ServiceException("地址不能为空");
		if (entity.getHiredate() == null)
			throw new ServiceException("入职时间不能为空");
		String salt = UUID.randomUUID().toString();// 借助随机字符串
		entity.setSalt(salt);
		// 对密码进行加密
		SimpleHash sHash = new SimpleHash("MD5", // 加密算法
				entity.getPassword(), salt);
		//System.out.println("sHash=" + sHash.toHex());
		//System.out.println("sHash=" + sHash.toString());
		entity.setPassword(sHash.toString());
		int rows;
		try {
			rows = sysEmployeeDao.updateObject(entity);
			System.out.println(rows);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("更新失败");
		}
		return rows;
	}

	@Override
	public SysEmployeeDeptResult findObjectById(Integer id) {
		if(id==null||id<1)throw new IllegalArgumentException("参数不合法");
		SysEmployeeDeptResult employee = sysEmployeeDao.findObjectById(id);
		if(employee==null)throw new ServiceException("此用户不存在");
		return employee;
	}

	

}

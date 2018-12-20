package com.jt.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.exception.ServiceException;
import com.jt.common.vo.PageObject;
import com.jt.sys.dao.SysLogDao;
import com.jt.sys.entity.SysLog;
import com.jt.sys.service.SysLogService;
@Service
public class SysLogServiceImpl implements SysLogService {

	@Autowired
	private SysLogDao sysLogDao;

	@Override
	public PageObject<SysLog> findPageObjects(String username, Integer pageCurrent) {
		//1.验证参数的合法性
		//1.1验证pageCurrent的合法性,不合法抛出IllegalArgumentException异常
		if(pageCurrent==null||pageCurrent<1){
			throw new IllegalArgumentException("当前页码不正确!");
		}
		//2.基于条件查询总记录数
		//2.1执行查询
		int rowCount=sysLogDao.getRowCount(username);
		//2.2验证查询结果,假如结果为0不再执行如下操作
		if(rowCount==0)throw new ServiceException("系统没有查到对应的记录");
		//3.基于条件查询当前页记录
		//3.1定义pageSize
		int pageSize=6;
		//3.2计算 startIndex
		int startIndex=(pageCurrent-1)*pageSize;
		//3.3执行当前数据的查询操作
		List<SysLog> records=sysLogDao.findPageObjects(username, startIndex, pageSize);
		//4.对分页信息以及当前页记录进行封装
		//4.1构建PageObject对象
		PageObject<SysLog> pageObject=new PageObject<>();
		//4.2封装数据
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setRowCount(rowCount);
		pageObject.setRecords(records);
        pageObject.setPageCount((rowCount-1)/pageSize+1);

		//5.返回封装结果
		
		return pageObject;
	}

	@Override
	public int deleteObjects(Integer[] ids) {
		//1.验证参数的合法性
		if(ids==null||ids.length==0)throw new IllegalArgumentException("请选择一个");
		//2.执行删除操作
		int rows;
		try {
			rows=sysLogDao.deleteObjects(ids);
		} catch (Exception e) {
			e.printStackTrace();
			//给运维人员发信息
			throw new ServiceException("系统故障,正在恢复中...");
		}
		//3.对结果进行验证
		if(rows==0)throw new ServiceException("要删除的记录可能已经不存在");
		//4.返回结果
		return rows;
	}

}

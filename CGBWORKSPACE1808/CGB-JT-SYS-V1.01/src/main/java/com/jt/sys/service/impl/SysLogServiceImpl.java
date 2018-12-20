package com.jt.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.jt.common.exception.ServiceException;
import com.jt.common.vo.PageObject;
import com.jt.sys.dao.SysLogDao;
import com.jt.sys.entity.SysMenu;
import com.jt.sys.entity.Syslog;
import com.jt.sys.service.SysLogService;
/**业务层对象
 * @Service 注解对于spring底层而言与@Controller的待遇一样的(Spring都会将其看成
 * 是由他管理的Bean对象)*/
@Service //<bean id="" class="">
public class SysLogServiceImpl implements SysLogService {

	@Autowired
	private SysLogDao sysLogDao;//ref
	//DI (SPRING)注入
	/*@Autowired//告诉spring帮我找这个类型的对象,然后自动注入DI注入
	public void setSysLogDao(SysLogDao sysLogDao) {
		this.sysLogDao = sysLogDao;
	}*/
	@Override
	public PageObject<Syslog> findPageObjects(String username, Integer pageCurrent) {
		//1.判定pageCurrent参数的合法性
		if(pageCurrent==null||pageCurrent<1)throw new IllegalArgumentException("当前页码不正确");
		//2.基于用户名统计日志记录总数
		int rowCount=sysLogDao.getRowCount(username);
		//3.对日志记录总数进行验证(总数为 0就没有必要继续查询)
		if(rowCount==0)throw new ServiceException("记录不存在");
		//4.查询当前页要显示的记录
		int pageSize=5;
		int startIndex=(pageCurrent-1)*pageSize;
		List<Syslog> records = sysLogDao.findPageObjects(username, startIndex, pageSize);
		//5.对象查询的记录,总记录数以及相关分页信息进行封装
		PageObject<Syslog> po=new PageObject<>();
		po.setRecords(records);
		po.setRowCount(rowCount);
		po.setPageSize(pageSize);
		po.setPageCurrent(pageCurrent);
		int pageCount=rowCount/pageSize;
		if(rowCount%pageSize!=0)pageCount++;
		//int pageCount=(rowCount-1)/pageSize+1;
		po.setPageCount(pageCount);//总页数
	
		//6.返回结果
		return po;
	}
	@Override
	public int deleteObjects(Integer... ids) {
		//1.验证参数的合法性
		if(ids==null||ids.length==0)throw new IllegalArgumentException("请先选择!");
		//2.执行删除操作
		int rows=sysLogDao.deleteObjects(ids);
		//3.验证删除结果
		if(rows==0)throw new ServiceException("记录可能已经不存在");
		return rows;
	}
	

}

package com.test;

import java.util.List;

import org.junit.Test;

import com.jt.sys.dao.SysLogDao;
import com.jt.sys.entity.Syslog;

public class TestSysLogDao extends TestBase {

	@Test
	public void testGetRowCount(){
		//1.获取dao对象
		SysLogDao dao = ctx.getBean("sysLogDao",SysLogDao.class);
		System.out.println(dao);
		//2.调用到方法
		int rowCount = dao.getRowCount("admin");
		//3.输出结果 
		System.out.println("rowCount"+rowCount);
	}
	@Test
	public void testFindPageObjects(){
		//1.获取dao对象
		SysLogDao dao = ctx.getBean("sysLogDao",SysLogDao.class);
		System.out.println(dao);
		//2.调用到方法
		List<Syslog> list = dao.findPageObjects("admin", 0, 3);
		//3.输出结果 
		for(Syslog log:list){
			System.out.println(log);
		}
	}
}

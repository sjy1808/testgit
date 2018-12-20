package com.test;

import java.util.List;

import org.junit.Test;

import com.jt.sys.dao.SysLogDao;
import com.jt.sys.entity.SysLog;

public class TestSysLog extends TestBase {

	@Test
	public void testGetRowCount(){
		//1.获取dao对象
		SysLogDao dao = cpx.getBean("sysLogDao",SysLogDao.class);
		System.out.println(dao);
		//2.调用方法
		int rowCount=dao.getRowCount("admin");
		//3.输出结果
		System.out.println(rowCount);
	}
	@Test
	public void testFindPageObjects(){
		SysLogDao dao = cpx.getBean("sysLogDao", SysLogDao.class);
		List<SysLog> list=dao.findPageObjects("admin",0,10);
		for(SysLog log:list){
			System.out.println(log);
		}
	}
}

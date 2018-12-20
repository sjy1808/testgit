package com.test;

import org.junit.Assert;
import org.junit.Test;

import com.jt.common.vo.PageObject;
import com.jt.sys.entity.Syslog;
import com.jt.sys.service.impl.SysLogServiceImpl;

public class TestSysLogService  extends TestBase{

	@Test
	public void testSysLogServiceImpl(){
		//1.获取service对象
		SysLogServiceImpl logService = ctx.getBean("sysLogServiceImpl",SysLogServiceImpl.class);
		//测试logService值是否不等于空
		Assert.assertNotEquals(
				null,//unexpected(不期望出现的值)
				logService);//actual(实际值)
		//2.调用service调用
		PageObject<Syslog> po = logService.findPageObjects("admin", 1);
		//3.输出结果
		System.out.println("rowCount="+po.getRowCount());
		System.out.println("pageCount="+po.getPageCount());
		for(Syslog log:po.getRecords()){
			System.out.println(log);
		}
	}
}

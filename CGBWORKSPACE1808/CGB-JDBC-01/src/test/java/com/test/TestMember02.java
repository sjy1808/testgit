package com.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.pt.member.dao.MemberDao;
import com.pt.member.dao.impl.MemberDaoImpl;
/***
 * Junit是什么:单元测试框架
 * Junit应用场景:JAVA生态项目中对方法进行单元测试
 * Junit框架应用的理由:方便对方法进行更好的测试
 * Juni框架如何应用
 * 1.添加依赖
 * 2.定义测试类,测试方法,并使用@Test进行描述
 */
public class TestMember02 {

	@Test
	public void testFindMembers(){
		//1.构建MemberDao对象
		MemberDao dao=new MemberDaoImpl();
		//2.调用对象方法查询会员信息
		List<Map<String,Object>> list=dao.findMembers();
		//3.输出查询结果
		for(Map<String,Object> map:list){
			System.out.println(map);
		}
	}
}

package com.test;

import java.util.List;
import java.util.Map;

import com.pt.member.dao.MemberDao;
import com.pt.member.dao.impl.MemberDaoImpl;

public class TestMember01 {
	public static void main(String[] args) {
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

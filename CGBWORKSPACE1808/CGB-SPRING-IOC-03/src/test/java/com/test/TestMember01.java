package com.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class TestMember01 extends TestBase{

	@Test
	public void testDeleteMember(){
		SqlSessionFactory factory=ctx.getBean("sqlSessionFactory", SqlSessionFactory.class);
		SqlSession session=factory.openSession();
		int rows=session.update("com.pt.member.dao.MemberDao.deleteMember", 1);
		System.out.println(rows);
		session.close();
	}
}

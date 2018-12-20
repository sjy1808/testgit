package com.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class TestMyBatis extends TestBase {

	@Test
	public void testSqlSesssionFactory(){
		SqlSessionFactory ssf=ctx.getBean("sqlSessionFactory",SqlSessionFactory.class);
		System.out.println(ssf);
	}
	@Test
	public void testDeleteMember(){
		SqlSessionFactory ssf=ctx.getBean("sqlSessionFactory",SqlSessionFactory.class);
		SqlSession session=ssf.openSession();
		String namespace="com.pt.member.dao.MemberDao";
		String eId="deleteMember";
		String statement=namespace+"."+eId;
		int rows=session.delete(statement,13);
		System.out.println(rows);
		session.commit();
		session.close();
		
	}
}

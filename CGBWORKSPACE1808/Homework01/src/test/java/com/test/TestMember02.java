package com.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.pt.member.dao.MemberDao;
import com.pt.member.entity.Member;

public class TestMember02  extends TestBase{

	@Test
	public void testFindPageObjects(){
		SqlSession session=factory.openSession();
		MemberDao dao=session.getMapper(MemberDao.class);
		List<Member> list=dao.findPageObjects();
		System.out.println(list);
		session.close();
	}
}

package com.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.pt.member.dao.MemberDao;
import com.pt.member.entity.Member;

public class TestMember02 extends TestBase{

	@Test
	public void testFindPageObjects(){
		SqlSession session=factory.openSession();
		//当执行getMapper方法时,系统底层会指定接口产生一个实现类的对象
		MemberDao dao=session.getMapper(MemberDao.class);
		System.out.println(dao.getClass().getName());
		List<Member> list=dao.findPageObjects(0,2);
		for(Member m:list){
			System.out.println(m);
		}
//		System.out.println(list);
		session.close();
		
	}
}

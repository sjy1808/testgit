package com.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.pt.member.entity.Member;

public class TestMember01  extends TestBase{

	@Test
	public void testFindMembers(){
		//1.创建SQLSession对象(相当于创建一个连接)
		SqlSession session=factory.openSession();
		//2.执行查询操作(selectList(命名空间+元素id))
		List<Member> list=session.selectList("com.pt.member.dao.MemberDao.findObjects");
		for(Object o:list){
			System.out.println(o);
		}
		//3.释放资源
		session.close();
	}
	@Test
	public void testInsertObject(){
		SqlSession session=factory.openSession();
		String statement="com.pt.member.dao.MemberDao.insertObject";
		Member m=new Member();
		m.setNickname("nick-02");
		m.setRealname("real-02");
		m.setPassword("123456");
		m.setGender("MALE");
		m.setEmail("e1@t.com");
		m.setMobile("11111111111");
		m.setRank(1);
		m.setSafequestion("1+1=?");
		m.setSafeanswer("2");
        m.setCreatedTime(new java.util.Date());
        int rows=session.insert(statement,m);
        System.out.println(rows);
		session.commit();//插入需要手动提交事务
		session.close();
	}
	@Test
	public void updateObject(){
		SqlSession session=factory.openSession();
		String statement="com.pt.member.dao.MemberDao.updatePassword";
		Member m=new Member();
		m.setId(1);
		m.setPassword("789789");
		int rows=session.update(statement,m);
		session.commit();
		session.close();
	}
	@Test
	public void testObject(){
		SqlSession session=factory.openSession();
		String statement="com.pt.member.dao.MemberDao.deleteObject";
		session.delete(statement,1);
		session.commit();
		session.close();
	}
}

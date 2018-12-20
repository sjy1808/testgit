package com.test;

import java.util.List;
import com.pt.member.entity.Member;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


public class TestMember01 extends TestBase{

	@Test
	public void testFindMembers(){
			//1.创建SqlSession对象(相当于创建一个连接)
			SqlSession session=factory.openSession();
			//2.执行查询操作(selectList("命名空间"+"元素id"))
			List<Member> list=session.selectList(
			"com.pt.member.dao.MemberDao.findObjects");
			for(Object o:list){
			System.out.println(o);
			}
			//3.释放资源(类似关闭连接)
			session.close();
		}
	@Test
	public void testFindObjects(){
		SqlSession session=factory.openSession();
		String namespace="com.pt.member.dao.MemberDao";
		String eId="findObjects";
		String statement=namespace+"."+eId;
		List<Member> list=session.selectList(statement);
		for(Member m:list){
			System.out.println(m);
		}
		session.close();
	}
	@Test
	public void testInsertObject() {
			SqlSession session=factory.openSession();//默认事务手动提交
//			SqlSession session=factory.openSession(true);//事务自动提交
			String statement="com.pt.member.dao.MemberDao.insertObject";
			Member m=new Member();
			m.setNickname("tony");
			m.setRealname("skdjf");
			m.setPassword("123456");
			m.setGender("MALE");
			m.setEmail("e1@t.com");
			m.setMobile("11111111111");
			m.setRank(1);
			m.setSafequestion("1+1=?");
			m.setSafeanswer("2");
	        m.setCreatedTime(new java.util.Date());
			int rows=session.insert(statement,m);
			System.out.println("rows="+rows);
			session.commit();//提交事务
			session.close();
		}
	@Test
	public void testUpdatePassword() {
			SqlSession session=factory.openSession();
			String statement="com.pt.member.dao.MemberDao.updatePassword";
			/*Object params[]= {"654321",1};
			int rows=session.update(statement, params);*/
			Member m=new Member();
			m.setId(2);
			m.setPassword("789789");
			int rows=session.update(statement,m);
			session.commit();
			System.out.println(rows);
			session.close();
		}
	@Test
	public void testDeleteObject() {
			SqlSession session=factory.openSession();
			String statement="com.pt.member.dao.MemberDao.deleteObject";
			int id=6;
			int rows=session.update(statement, id);
			session.commit();
			System.out.println(rows);
			session.close();
		}



}

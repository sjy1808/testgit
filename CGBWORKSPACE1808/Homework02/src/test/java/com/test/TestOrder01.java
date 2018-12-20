package com.test;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.pt.order.dao.OrderDao;
import com.pt.order.entity.Order;
import com.pt.order.vo.OrderVo;
import com.pt.order.vo.SqlOrderCommand;

public class TestOrder01 extends TestBase{

	@Test
	public void testFindPageObjects(){
		SqlSession session=factory.openSession();
		OrderDao dao=session.getMapper(OrderDao.class);
		List<OrderVo> list = dao.findPageObjects();
		for(OrderVo o:list){
			System.out.println(o);
		}
		session.close();
	}
	@Test
	public void testFindPageObject(){
		SqlSession session=factory.openSession();
		OrderDao dao=session.getMapper(OrderDao.class);
		SqlOrderCommand command=new SqlOrderCommand();
		command.setColumn("id");
		command.setType("desc");
		List<Order> list=dao.findPageObject(command);
		for(Order o:list){
			System.out.println(o);
		}
		session.close();
	}
	@Test
	public void testInsertObject(){
		SqlSession session=factory.openSession();
		OrderDao dao=session.getMapper(OrderDao.class);
		Order o=new Order();
		o.setCode("100001");
		o.setMemberId(1);
		o.setGoodsId(1);
		o.setTotalPrice(100.0f);
		o.setStatus(1);
		o.setRemark("mark ...");
		dao.insertObject(o);
		session.commit();
		session.close();

	}
	@Test
	public void testInsertObjects(){
		SqlSession session=factory.openSession(ExecutorType.BATCH);
		OrderDao dao=session.getMapper(OrderDao.class);
		Order o=new Order();
		o.setCode("100003");
		o.setMemberId(1);
		o.setGoodsId(1);
		o.setTotalPrice(100.0f);
		o.setStatus(1);
		o.setRemark("mark ...");
		dao.insertObject(o);
		session.commit();
		session.close();
	}
}

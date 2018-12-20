package com.test;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.pt.order.dao.OrderDao;
import com.pt.order.entity.Order;
import com.pt.order.vo.OrderVo;
import com.pt.order.vo.SqlOrderCommand;

public class TestOrder01 extends TestBase {

	@Test
	public void testFindPageObjects(){
		//1.创建SqlSession对象
		SqlSession session=factory.openSession();
		//2.获取Dao接口
		OrderDao dao=session.getMapper(OrderDao.class);
		//3.执行查询操作
		SqlOrderCommand cmd=new SqlOrderCommand();
		cmd.setColumn("id");
		cmd.setType("desc");
		List<OrderVo> list=dao.findPageObjects(cmd);
		//4.输出结果
		for(OrderVo o:list){
			System.out.println(o.getCode());
			System.out.println(o.getMember());
		}
		//5.释放资源
		session.close();
	}
	@Test
	public void testInsertObject(){
		//创建SqlSession对象
		SqlSession session=factory.openSession();
		//新建实体类对象
		Order o=new Order();
		o.setCode("201810311032");
		o.setMemberId(3);
		o.setGoodsId(1004);
		o.setTotalprice(2000.0f);
		o.setStatus(2);
		o.setRemark("order...");
		//将对象持久化到数据库
		OrderDao dao=session.getMapper(OrderDao.class);
		int rows=dao.insertObject(o);
		session.commit();
		session.close();
		System.out.println("insert.rows="+rows);
		//如何获取刚刚写入的订单id
		System.out.println("order.id="+o.getId());
	}
	@Test
	public void deleteOrder(){
		SqlSession session=factory.openSession(ExecutorType.BATCH);
		//其中ExcutorType.BATCH表示系统底层会调用BatchExcutor执行器执行sql操作
		OrderDao dao=session.getMapper(OrderDao.class);
		dao.deleteObject(5);
		dao.deleteObject(6);
		//session.commit();
		session.close();
		System.out.println("delete ok");
	}
	@Test
	public void deleteObjectByIds(){
		SqlSession session=factory.openSession();
		OrderDao dao=session.getMapper(OrderDao.class);
		dao.deleteObjectByIds(null);
		//session.commit();
		session.close();
		System.out.println("delete ok");
	}
}


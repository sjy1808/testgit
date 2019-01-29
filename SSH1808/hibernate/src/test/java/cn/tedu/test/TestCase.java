package cn.tedu.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.tedu.User;

public class TestCase {

	@Test
	public void testUser() {
		//读取配置文件
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		//获取session对象
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		//通过session操作数据库
		User u = (User) session.get(User.class, 1);
		System.out.println(u);
		session.close();
	}
}

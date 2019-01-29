package cn.tedu.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.User;
import cn.tedu.dao.UserDao;

public class TestCase {

	@Test
	public void testUserDao() {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring-mybatis.xml");
		UserDao dao=ctx.getBean("userDao",UserDao.class);
		User user = new User();
		user.setId(2);
		user.setName("Tom");
		dao.save(user);
	}
}

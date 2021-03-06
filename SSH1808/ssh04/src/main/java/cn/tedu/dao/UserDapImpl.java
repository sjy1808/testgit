package cn.tedu.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.entity.User;

@Repository("userDao")
@Transactional
public class UserDapImpl implements UserDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	@Override
	public void save(User user) {
		hibernateTemplate.save(user);
	}

	@Override
	public void update(User user) {
		hibernateTemplate.update(user);
	}

	@Override
	public void delete(User user) {
		hibernateTemplate.delete(user);
	}

	@Override
	public User findByName(String name) {
		String hql="from User where name=:name";
		List list=hibernateTemplate.findByNamedParam(hql, "name", name);
		return (User) list.get(0);
	}

	
}

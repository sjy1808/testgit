package cn.tedu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public User login(String name, String password) {
		User user=userDao.findByName(name);
		if((user!=null)&&user.getPassword().equals(password)) {
			System.out.println(user);
			return user;
		}
		return null;
	}
}
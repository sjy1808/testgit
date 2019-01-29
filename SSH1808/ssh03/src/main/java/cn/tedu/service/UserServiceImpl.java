package cn.tedu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.Result;
import cn.tedu.UserPwd;
import cn.tedu.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public Result login(String name, String password) {
		UserPwd user=userDao.findByName(name);
		Result result = new Result();
		//判断用户名是否存在
		if(user==null) {
			result.setStatus(1);
			result.setMsg("用户名不存在");
			return result;
		}
		//登录成功
		result.setStatus(0);
		result.setMsg("登录成功");
		user.setPassword("");
		result.setData(user);
		return result;
	}

}

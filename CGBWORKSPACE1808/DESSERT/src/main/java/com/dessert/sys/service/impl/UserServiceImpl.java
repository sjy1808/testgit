package com.dessert.sys.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.dessert.common.vo.PageObject;
import com.dessert.exception.ServiceException;
import com.dessert.sys.dao.OrdersDao;
import com.dessert.sys.dao.UserDao;
import com.dessert.sys.dao.UserOrdersDao;
import com.dessert.sys.orders.entity.User;
import com.dessert.sys.service.UserService;
import com.dessert.sys.vo.UserOrders;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private OrdersDao ordersDao;
	@Autowired
	private UserOrdersDao userOrdersDao;

	@Override
	public PageObject<UserOrders> findPageObjects(String username, Integer pageCurrent) {
		if (pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("当前页码不正确");
		int Count = userDao.getRowCount(username);
		if (Count == 0)
			throw new ServiceException("系统没有找到数据");
		int pageSize = 3;
		int startIndex = (pageCurrent - 1) * pageSize;
		List<UserOrders> list = userDao.findPageObjects(username, startIndex, pageSize);
		PageObject<UserOrders> pageObject = new PageObject<>();
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setRowCount(Count);
		pageObject.setRecords(list);
		pageObject.setPageCount((Count - 1) / pageSize + 1);
		return pageObject;
	}

	@Override
	public int saveObject(User entity) {
		// 1.参数有效性验证
		if (entity == null)
			throw new IllegalArgumentException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getUsername()))
			throw new IllegalArgumentException("用户名不能为空");
		if (StringUtils.isEmpty(entity.getPassword()))
			throw new IllegalArgumentException("密码不能为空");
		// 2.保存用户自身信息
		// 2.1产生随机字符串作为一个盐值
		String salt = UUID.randomUUID().toString();
		entity.setSalt(salt);
		// 2.2对密码进行加密(借助shiro中api)
		// DigestUtils.md5DigestAsHex(bytes)//spring中自带API
		SimpleHash sHash = new SimpleHash(// Shiro中API
				"md5", // algorithmName为加密算法
				entity.getPassword(), // source 密码
				salt);// salt 盐值
		entity.setPassword(sHash.toHex());
		// 2.3持久化用户自身信息
		int rows = userDao.insertObject(entity);
		// 4.返回结果
		return rows;
	}

	@Override
	public int updateObject(User entity) {
		// 1.参数有效性验证
		if (entity == null)
			throw new IllegalArgumentException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getUsername()))
			throw new ServiceException("此用户名不能为空");
		if (StringUtils.isEmpty(entity.getPassword()))
			throw new IllegalArgumentException("密码不能为空");
		if (StringUtils.isEmpty(entity.getEmail()))
			throw new ServiceException("邮箱不能为空");
		if (StringUtils.isEmpty(entity.getMobile()))
			throw new ServiceException("手机号不能为空");
		if (StringUtils.isEmpty(entity.getAddress()))
			throw new ServiceException("地址不能为空");
		String salt = UUID.randomUUID().toString();
		entity.setSalt(salt);
		// 2.2对密码进行加密(借助shiro中api)
		// DigestUtils.md5DigestAsHex(bytes)//spring中自带API
		SimpleHash sHash = new SimpleHash(// Shiro中API
				"md5", // algorithmName为加密算法
				entity.getPassword(), // source 密码
				salt);// salt 盐值
		entity.setPassword(sHash.toHex());
		// 2.保存用户自身信息
		int rows = userDao.updateObject(entity);
		if (rows == 0)
			throw new ServiceException("更新失败");
		// 4.返回结果
		return rows;
	}

	@Override
	public int deleteObjects(Integer id) {
		if (id == null || id < 1)
			throw new IllegalArgumentException("请先选择");
		int rows = userDao.deleteObjects(id);
		if (rows == 0)
			throw new ServiceException("记录可能已经不存在");
		int id1 = id;
		System.out.println(id1);
		int a = ordersDao.deleteObjectsByUserId(id1);
		System.out.println(a);
		int b = userOrdersDao.deleteObjectsByUserId(id1);
		System.out.println(b);
		return rows;
	}

	@Override
	public User findObject(Integer id) {
		if (id == null || id < 1)
			throw new IllegalArgumentException("参数异常");
		User user = userDao.findObjects(id);
		if (user == null)
			throw new ServiceException("记录可能不存在");
		return user;
	}

	@Override
	public User findObjectByUsername(String username) {
		User user = userDao.findUserByUserName(username);
		
		return user;
	}


}
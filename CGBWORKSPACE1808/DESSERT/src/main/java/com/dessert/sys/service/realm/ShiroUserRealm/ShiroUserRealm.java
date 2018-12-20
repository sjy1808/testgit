package com.dessert.sys.service.realm.ShiroUserRealm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dessert.sys.dao.UserDao;
import com.dessert.sys.orders.entity.User;

@Service
public class ShiroUserRealm extends AuthorizingRealm {

	@Autowired
	private UserDao userDao;

	/**
	 * 设置凭证匹配器
	 */
	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		// 1.构建匹配器对象
		HashedCredentialsMatcher hcm = new HashedCredentialsMatcher("MD5");
		// 2.设置加密次数
		hcm.setHashIterations(1);
		super.setCredentialsMatcher(hcm);
	}

	/* 在此方法完成用户信息的获取以及封装 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 1.从参数token中获取用户信息
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		// 2.基于用户名从数据库查找用户信息
		System.out.println(username);
		User user = userDao.findUserByUserName(username);
		System.out.println(user);
		// 3.验证用户是否存在
		if (user == null)
			throw new UnknownAccountException();
		/*
		 * 4.验证用户是否已被禁用 if (user.getValid() == 0) throw new
		 * LockedAccountException();
		 */

		// 5.封装用户信息(包含密码等)
		ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, // 用户身份
				user.getPassword(), // 已加密的密码
				credentialsSalt, // 盐值
				getName());
		return info;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

}
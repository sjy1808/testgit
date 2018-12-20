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

import com.dessert.sys.dao.SysEmployeeDao;
import com.dessert.sys.orders.entity.SysEmployee;
@Service
public class ShiroEmployeeRealm extends AuthorizingRealm {

	@Autowired
	private SysEmployeeDao sysEmployeeDao;
	/**
	 * 设置凭证匹配
	 * @param credentialsMatcher
	 */
	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		//1.构建一个凭证匹配器对象
		HashedCredentialsMatcher hcm = new HashedCredentialsMatcher("MD5");
		//设置加密次数
		hcm.setHashIterations(1);
		super.setCredentialsMatcher(hcm);
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 执行认证操作时,此方法用户获取用户认证信息,该方法由认证管理器调用
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//1.从参数token中获取员工信息
		UsernamePasswordToken upToken=(UsernamePasswordToken)token;
		String username=upToken.getUsername();
		//2.基于username从数据库中查找员工的信息
		SysEmployee employee=null;
		employee=sysEmployeeDao.findEmployeeByUserName(username);
		//3.验证员工是否存在
		if(employee==null)throw new UnknownAccountException();
		
		//4.封装用户信息(包含密码)
		//4.1处理盐值数据,封装为ByteSource对象
		ByteSource credentialsSalt=ByteSource.Util.bytes(employee.getSalt());
		SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(
				employee,//principal  用户身份
				employee.getPassword(),//hashedCredentials(已加密的密码)
				credentialsSalt,//credentialsSalt(盐)
				this.getName());//realm name
		return info;//返回给了认证管理器
	}

}

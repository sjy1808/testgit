package com.jt.sys.service.realm;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.jt.sys.dao.SysMenuDao;
import com.jt.sys.dao.SysRoleMenuDao;
import com.jt.sys.dao.SysUserDao;
import com.jt.sys.dao.SysUserRoleDao;
import com.jt.sys.entity.SysUser;
@Service
public class ShiroUserRealm extends AuthorizingRealm {

	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	@Autowired
	private SysMenuDao sysMenuDao;
	/**
	 * 设置登录时使用的凭证匹配器
	 */
	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		//1.构建一个凭证匹配器对象
		HashedCredentialsMatcher hcm = new HashedCredentialsMatcher("MD5");
		//2.设置加密次数
		hcm.setHashIterations(1);
		super.setCredentialsMatcher(hcm);
	}
	/**在此方法中完成用户信息的获取以及封装*/
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//1.从参数token中获取用户信息
		UsernamePasswordToken upToken=(UsernamePasswordToken)token;
		String username=upToken.getUsername();
		//2.基于用户名从数据库查找用户信息
		SysUser user=null;
		user=sysUserDao.findUserByUserName(username);
		//3.验证用户是否存在
		if(user==null)throw new UnknownAccountException();
		//4.验证用户是否已被禁用
		if(user.getValid()==0)throw new LockedAccountException();
		//5.封装用户信息(包含密码)
		//5.1处理盐值数据,封装为ByteSource对象
		ByteSource credentialsSalt=ByteSource.Util.bytes(user.getSalt());
		SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(
				user,//principal 用户身份
				user.getPassword(),//hashedCredentials(已经加密的密码)
				credentialsSalt,//credentialsSalt(盐)
				this.getName());//realm name
		return info;//此对象返回给了认证管理器
	}
	
	//private Map<String,SimpleAuthorizationInfo> pCache=new ConcurrentHashMap<>();
	/**在此方法中完成用户权限信息的获取以及封装*/
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//1.获取当前用户
		SysUser user = (SysUser) principals.getPrimaryPrincipal();
		//2.获取用户拥有角色信息(基于用户id获取角色id)
		/*if(pCache.containsKey(user.getUsername())){
			return pCache.get(user.getUsername());
		}*/
		System.out.println("doGetAuthorizationInfo");
		List<Integer> roleIds = sysUserRoleDao.findRoleIdsByUserId(user.getId());
		System.out.println("roleIds:"+roleIds);
		if(roleIds==null||roleIds.size()==0)throw new AuthorizationException();
		//3.获取这些角色对应菜单(资源 ,基于角色id获取菜单id)
		List<Integer> menuIds = sysRoleMenuDao.findMenuIdsByRoleIds(roleIds.toArray(new Integer[]{}));
		if(menuIds==null||menuIds.size()==0)
			throw new AuthorizationException();
		//4.获取菜单id对应的权限标识(sys:user:valid,基于菜单id查找权限标识信息)
		System.out.println("menuIds:"+menuIds);
		List<String> permissions = sysMenuDao.findPermissions(menuIds.toArray(new Integer[]{}));
		System.out.println("permissions:"+permissions);
		if(permissions==null||permissions.size()==0)throw new AuthorizationException();
		//5.封装权限信息,并返回
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		Set<String> set=new HashSet<>();
		for(String per:permissions){
			if(!StringUtils.isEmpty(per)){
				set.add(per);
			}
		}//去重和空
		System.out.println(set);
		info.setStringPermissions(set);
		//pCache.put(user.getUsername(), info);
		return info;
	}


}

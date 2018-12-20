package com.jt.sys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jt.common.anno.RequiresLog;
import com.jt.common.exception.ServiceException;
import com.jt.common.vo.CheckBox;
import com.jt.common.vo.PageObject;
import com.jt.sys.dao.SysUserDao;
import com.jt.sys.dao.SysUserRoleDao;
import com.jt.sys.entity.SysUser;
import com.jt.sys.service.SysUserService;
import com.jt.sys.vo.SysUserDeptResult;
/**业务层对象
 * @Service 注解对于spring底层而言与@Controller的待遇一样的(Spring都会将其看成
 * 是由他管理的Bean对象)*/
@Service //<bean id="" class="">
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserDao sysUserDao;//ref
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	//DI (SPRING)注入
	/*@Autowired//告诉spring帮我找这个类型的对象,然后自动注入DI注入
	public void setSysLogDao(SysLogDao sysLogDao) {
		this.sysLogDao = sysLogDao;
	}*/
	@Override
	public PageObject<SysUserDeptResult> findPageObjects(String username, Integer pageCurrent) {
		//1.判定pageCurrent参数的合法性
		if(pageCurrent==null||pageCurrent<1)throw new IllegalArgumentException("当前页码不正确");
		//2.基于用户名统计日志记录总数
		int rowCount=sysUserDao.getRowCount(username);
		//3.对日志记录总数进行验证(总数为 0就没有必要继续查询)
		if(rowCount==0)throw new ServiceException("记录不存在");
		//4.查询当前页要显示的记录
		int pageSize=5;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysUserDeptResult> records = sysUserDao.findPageObjects(username, startIndex, pageSize);
		//5.对象查询的记录,总记录数以及相关分页信息进行封装
		PageObject<SysUserDeptResult> po=new PageObject<>();
		po.setRecords(records);
		po.setRowCount(rowCount);
		po.setPageSize(pageSize);
		po.setPageCurrent(pageCurrent);
		int pageCount=rowCount/pageSize;
		if(rowCount%pageSize!=0)pageCount++;
		//int pageCount=(rowCount-1)/pageSize+1;
		po.setPageCount(pageCount);//总页数
	
		//6.返回结果
		return po;
	}
	/**
	 * 项目中需要授权访问的方法需要添加@ReRequiresPermissions注解,指定
	 * 访问此方法需要的权限
	 * 需要在业务层实现
	 * 当用户拥有这写权限时便可授权访问
	 * 系统底层原理:
	 * 系统底层会通过Subject.isPermitted(sys:user:valid)
	 * 提交给授权管理器,授权管理器就会检测认证用户是否拥有此权限
	 */
	@RequiresPermissions("sys:user:valid")
	@RequiresLog("禁用启用")
	@Override
	public int validById(Integer id,
						Integer valid,
						String modifiedUser) {
		//1.合法性验证
		if(id==null||id<=0)
		throw new ServiceException("参数不合法,id="+id);
		if(valid!=1&&valid!=0)
		throw new ServiceException("参数不合法,valie="+valid);
		if(StringUtils.isEmpty(modifiedUser))
		throw new ServiceException("修改用户不能为空");
		//2.执行禁用或启用操作
		int rows=0;
		try{
	    rows=sysUserDao.validById(id, valid, modifiedUser);
		}catch(Throwable e){
		e.printStackTrace();
		//报警,给维护人员发短信
		throw new ServiceException("底层正在维护");
		}
		//3.判定结果,并返回
		if(rows==0)
		throw new ServiceException("此记录可能已经不存在");
		return rows;
	}
	@Override
	public List<CheckBox> findObjects() {
		return sysUserDao.findObjects();
	}
	@Override
	public int saveObject(SysUser entity, Integer... roleIds) {
		//1.验证数据的合法性
		if(entity==null)throw new ServiceException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getUsername().trim()))throw new ServiceException("用户名不能为空");
		/*SysUserDeptResult user = sysUserDao.findObjectById(entity.getId());
		System.out.println(entity.getId());
		System.out.println(user);
		System.out.println("username="+user.getUsername());
		System.out.println("name="+entity.getUsername());*/
		//if(entity.getUsername().equals(user.getUsername()))throw new ServiceException("该用户名已存在,请重新填写用户名!");
		if(StringUtils.isEmpty(entity.getPassword().trim()))throw new ServiceException("密码不能为空");
		if(roleIds==null||roleIds.length==0)throw new ServiceException("至少要为用户分配一个角色");
		//2.将数据写入数据库
		//获取一个盐值对象
		String salt=UUID.randomUUID().toString();//借助随机字符串
		entity.setSalt(salt);
		//对密码进行加密
		SimpleHash sHash = new SimpleHash(
				"MD5",//加密算法
				entity.getPassword(),
				salt);
		System.out.println("sHash="+sHash.toHex());
		System.out.println("sHash="+sHash.toString());
		entity.setPassword(sHash.toString());
		
		int rows=sysUserDao.insertObject(entity);
		sysUserRoleDao.insertObjects(entity.getId(), roleIds);
		
		//3.返回结果
		return rows;
	}
	@Override
	public Map<String, Object> findObjectById(Integer userId) {
		//1.合法性验证
		if(userId==null||userId<0)throw new ServiceException("参数数据不合法,userId="+userId);
		//2.业务 查询
		SysUserDeptResult user = sysUserDao.findObjectById(userId);
		if(user==null)throw new ServiceException("此用户已经不存在");
		List<Integer> roleIds=sysUserRoleDao.findRoleIdsByUserId(userId);
		//3.数据封装
		Map<String,Object> map=new HashMap<>();
		map.put("user", user);
		map.put("roleIds", roleIds);
		return map;
	}
	@Override
	public int updateObject(SysUser entity,Integer[] roleIds) {
		//1.验证数据的合法性
		if(entity==null)throw new ServiceException("用户信息不能为空");
		if(StringUtils.isEmpty(entity.getUsername()))throw new ServiceException("用户名不能为空");
		if(StringUtils.isEmpty(roleIds))throw new ServiceException("用户必须选择一个角色");
		
		if(!StringUtils.isEmpty(entity.getPassword())){
			//对密码加密
			String salt=UUID.randomUUID().toString();
			SimpleHash hash=new SimpleHash("MD5",entity.getPassword(),salt);
			entity.setPassword(hash.toString());
		}
		//2.更新数据
		int rows=0;
		try {
			rows=sysUserDao.updateObject(entity);
			sysUserRoleDao.deleteObjectsByUserId(entity.getId());
			sysUserRoleDao.insertObjects(entity.getId(), roleIds);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("服务端现在异常,请稍后访问!");
		}
		//3.返回结果
		return rows;
	}

	

}

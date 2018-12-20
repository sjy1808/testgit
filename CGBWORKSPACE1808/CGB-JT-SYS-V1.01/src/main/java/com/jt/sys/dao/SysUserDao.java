package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.common.vo.CheckBox;
import com.jt.sys.entity.SysUser;
import com.jt.sys.vo.SysUserDeptResult;

/**
 * 用户持久层接口并定义查询方法获取表中用户信息
 * @author Administrator
 *
 */
public interface SysUserDao {
	/**
	 * 根据用户名查询用户对象的方法定义
	 * @param username
	 * @return
	 */
	SysUser findUserByUserName(String username);
	/**
	 * 负责将用户信息写入到数据库
	 * @param entity 实体对象数据(存储数据)
	 * @return
	 */
	int insertObject(SysUser entity);
	/**
	 * 查询角色id和角色方法
	 * @return
	 */
	List<CheckBox> findObjects();
	/**
	 * 禁用启用用户对象
	 * @param id
	 * @param valid
	 * @param modifiedUser
	 * @return
	 */
	int validById(
			@Param("id")Integer id,
			@Param("valid")Integer valid,
			@Param("modifiedUser")String modifiedUser);

	/**
	 * 查询当前页要显示的记录
	 * @param username 查询条件
	 * @param startIndex 当前页的起始位置
	 * @param pageSize 页面大小
	 * @return
	 */
	List<SysUserDeptResult> findPageObjects(
			@Param("username") String username,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	/**
	 * 依据查询条件获取总记录数(后续通过此值计算总页数)
	 * @param username
	 * @return
	 */
	int getRowCount(@Param("username") String username);
	/**
	 * 基于id查询用户以及部门的方法
	 * @param id
	 * @return
	 */
	SysUserDeptResult findObjectById(Integer id);
	/**
	 * 更新用户自身的数据
	 * @param entity
	 * @return
	 */
	int updateObject(SysUser entity);

}

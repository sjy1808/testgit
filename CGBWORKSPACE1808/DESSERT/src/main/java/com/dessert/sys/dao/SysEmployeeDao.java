package com.dessert.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dessert.sys.orders.entity.SysEmployee;
import com.dessert.sys.vo.SysEmployeeDeptResult;

public interface SysEmployeeDao {

	/**
	 * 基于条件分页查询员工信息
	 * @param name 查询条件
	 * @param startIndex 当前页的起始位置
	 * @param pageSize 当前页的页面大小
	 * @return 当前页的员工信息
	 */
	List<SysEmployeeDeptResult> findPageObjects(
			  @Param("name")String  name,
		      @Param("startIndex")Integer startIndex,
		      @Param("pageSize")Integer pageSize);
	/**
	 * 基于条件查询总记录数
	 * @param name 查询条件
	 * @return 总记录数
	 */
	int getRowCount(@Param("name")String name);
	/**
	 * 添加员工信息
	 * @param entity
	 * @return
	 */
	int insertObject(SysEmployee entity);
	/**
	 * 基于id删除员工信息
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
	/**
	 * 基于id查询员工信息
	 * @param id
	 * @return
	 */
	SysEmployeeDeptResult findObjectById(Integer id);
	/**
	 * 基于id修改员工信息
	 * @param id
	 * @return
	 */
	int updateObject(SysEmployee entity);
	/**
	 * 基于部门id查询该部门有多少员工
	 * @param DeptId
	 * @return
	 */
	int getEmployeeCountByDeptId (Integer DeptId);
	/**
	 * 根据用户名查询用户信息
	 * @param username
	 * @return
	 */
	SysEmployee findEmployeeByUserName(String username);
	
}

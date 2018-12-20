package com.dessert.sys.service;

import java.util.List;

import com.dessert.common.vo.PageObject;
import com.dessert.sys.entity.SysEmployee;

public interface SysEmployeeService {

	/**
	 * 通过此方法实现分页查询
	 * @param name 基于条件查询的参数名
	 * @param pageCurrent 当前的页码值
	 * @return 分页记录+分页信息
	 */
	PageObject<SysEmployee> findPageObjects(String name ,Integer pageCurrent);
	/**
	 * 保存员工信息
	 * @param entity
	 * @return
	 */
	int saveObject(SysEmployee entity);
	/**
	 * 删除员工信息
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
	/**
	 * 基于id查询员工信息
	 * @param id
	 * @return
	 */
	List<SysEmployee> findObjectById(Integer id);
	/**
	 * 更新员工信息
	 * @param entity
	 * @return
	 */
	int updateObject(SysEmployee entity);
}

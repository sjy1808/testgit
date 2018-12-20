package com.dessert.sys.service;

import java.util.List;
import java.util.Map;

import com.dessert.common.vo.Node;
import com.dessert.sys.orders.entity.SysDept;

public interface SysDeptService {

	/**
	 * 获取部门信息
	 * @return
	 */
	List<Map<String,Object>> findObjects();
	/**
	 * 基于id删除部门信息
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
	/**
	 * 获取部门节点信息
	 * @return
	 */
	List<Node> findZtreeDeptNodes();
	/**
	 * 获取页面数据
	 * @param entity
	 * @return
	 */
	int saveObject(SysDept entity);
	/**
	 * 获取页面数据,更新数据库
	 * @param entity
	 * @return
	 */
	int updateObject(SysDept entity);
}

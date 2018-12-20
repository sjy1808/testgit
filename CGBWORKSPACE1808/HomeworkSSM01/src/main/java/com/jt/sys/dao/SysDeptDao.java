package com.jt.sys.dao;

import java.util.List;
import java.util.Map;

import com.jt.common.vo.Node;

public interface SysDeptDao {

	/**
	 * 查询数据库中所有的部门信息
	 * @return
	 */
	List<Map<String,Object>> findObjects();
	/**
	 * 基于id查询是否有子元素
	 * @param id
	 * @return
	 */
	int getChildCount(Integer id);
	/**
	 * 基于id删除部门信息
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
	/**
	 * 查询树节点的所有部门信息(id,name,parentId)
	 * @return
	 */
	List<Node> findZtreeDeptNodes();
}

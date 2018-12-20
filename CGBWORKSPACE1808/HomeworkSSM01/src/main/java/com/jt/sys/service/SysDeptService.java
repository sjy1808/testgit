package com.jt.sys.service;

import java.util.List;
import java.util.Map;

import com.jt.common.vo.Node;

public interface SysDeptService {

	/**
	 * 业务数据层接口查询所有的部门信息
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
	 * 查询树节点的所有部门信息
	 * @return
	 */
	List<Node> findZtreeDeptNodes();
}
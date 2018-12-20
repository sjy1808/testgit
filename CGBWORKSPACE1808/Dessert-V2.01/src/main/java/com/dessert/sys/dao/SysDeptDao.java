package com.dessert.sys.dao;

import java.util.List;
import java.util.Map;

import com.dessert.common.vo.Node;
import com.dessert.sys.entity.SysDept;

public interface SysDeptDao {

	/**
	 * 查询所有部门以及上一级部门信息
	 * @return
	 */
	List<Map<String,Object>> findObjects();
	/**
	  * 根据部门id统计子部门的个数
	  * @param id
	  * @return
	  */
	 int getChildCount(Integer id);
	 /**
	  * 根据id 删除部门
	  * @param id
	  * @return
	  */
	 int deleteObject(Integer id);
	 /**
	  * 获取数据库中对应的部门表中的所有部门信息(id, name, parentId)
	  * @return
	  */
	 List<Node> findZtreeDeptNodes();
	 /**
	  * 向数据库添加数据
	  * @param entity
	  * @return
	  */
	 int insertObject(SysDept entity); 
	 /**
	  * 更新数据库数据
	  * @param entity
	  * @return
	  */
	 int updateObject(SysDept entity);

}

package com.jt.sys.dao;

import java.util.List;
import java.util.Map;

import com.jt.common.vo.Node;
import com.jt.sys.entity.SysMenu;

public interface SysMenuDao {

	/**
	 * 查询所有菜单以及上一级菜单信息
	 * @return list集合,集合中放map,一行记录对应一个map,这一级菜单和上级菜单信息放到一个map中
	 */
	List<Map<String,Object>> findObjects();
	/**
	 * 根据菜单id统计子菜单的个数
	 * @param id
	 * @return
	 */
	int getChildCount(Integer id);
	/**
	 * 根据id删除菜单
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
	/**
	 * 查询菜单zTree树的节点信息
	 * @return
	 */
	List<Node> findZtreeMenuNodes();
	/**
	 * 将菜单信息写入到数据库中
	 * @param entity
	 * @return
	 */
	int insertObject(SysMenu entity);
	/**
	 * 修改数据库中的数据
	 * @param entity
	 * @return
	 */
	int updateObject(SysMenu entity);
	
}

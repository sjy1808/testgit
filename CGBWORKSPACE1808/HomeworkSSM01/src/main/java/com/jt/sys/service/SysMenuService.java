package com.jt.sys.service;

import java.util.List;
import java.util.Map;

import com.jt.common.vo.Node;
import com.jt.sys.entity.SysMenu;

public interface SysMenuService {

	/**
	 * 查询业务层接口
	 * @return
	 */
	List<Map<String,Object>> findObjects();
	/**
	 * 基于id执行删除操作
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
	/**
	 * 查询菜单节点信息,并将结果封装到Node中
	 * @return
	 */
	List<Node> findZtreeMenuNodes();
	/**
	 * 将菜单信息添加到数据库
	 * @param entity
	 * @return
	 */
	int insertObject(SysMenu entity);
	/**
	 * 将页面上修改的数据存入数据库
	 * @param entity
	 * @return
	 */
	int updateObject(SysMenu entity);
}

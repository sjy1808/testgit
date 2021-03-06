package com.jt.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.exception.ServiceException;
import com.jt.common.vo.Node;
import com.jt.sys.dao.SysDeptDao;
import com.jt.sys.dao.SysUserDao;
import com.jt.sys.service.SysDeptService;
@Service
public class SysDeptServiceImpl implements SysDeptService {

	@Autowired
	private SysDeptDao sysDeptDao;
	
	@Autowired
	private SysUserDao sysUserDao;
	
	@Override
	public List<Map<String, Object>> findObjects() {
		List<Map<String, Object>> list = sysDeptDao.findObjects();
		return list;
	}

	@Override
	public int deleteObject(Integer id) {
		if(id<1||id==null)throw new IllegalArgumentException("数据不合法");
		int childCount=sysDeptDao.getChildCount(id);
		if(childCount>0)throw new ServiceException("此元素有子元素,不允许删除");
		int userCount=sysUserDao.getUserCountByDeptId(id);
		if(userCount>0)throw new ServiceException("此部门有员工,不允许对部门进行删除");
		int rows=sysDeptDao.deleteObject(id);
		if(rows==0)throw new ServiceException("此信息可能已经不存在!");
		return rows;
	}

	@Override
	public List<Node> findZtreeDeptNodes() {
		List<Node> nodes = sysDeptDao.findZtreeDeptNodes();
		return nodes;
	}

}

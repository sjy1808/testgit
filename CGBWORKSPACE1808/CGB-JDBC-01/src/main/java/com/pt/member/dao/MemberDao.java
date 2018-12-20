package com.pt.member.dao;

import java.util.List;
import java.util.Map;

/**
 * 会员模块:数据访问对象(DAO)
 */
public interface MemberDao {
	/**
	 * 查询系统中所有会员信息
	 * 1.一行会员信息映射为一个Map对象
	 * 2.多行记录要存储到list集合
	 * @return
	 */
	List<Map<String, Object>> findMembers();
}

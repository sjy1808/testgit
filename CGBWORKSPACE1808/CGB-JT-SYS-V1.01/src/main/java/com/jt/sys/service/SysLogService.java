package com.jt.sys.service;

import com.jt.common.vo.PageObject;
import com.jt.sys.entity.Syslog;

public interface SysLogService {
	
	/**
	 * 基于id执行删除操作
	 * @param ids
	 * @return
	 */
	int deleteObjects(Integer... ids);
	/**
	 * 查询当前页记录以及总记录数并对其进行封装
	 * @param username 查询用户名
	 * @param pageCurrent 当前页的页码
	 * @return
	 */
	PageObject<Syslog> findPageObjects(String username, Integer pageCurrent);
}

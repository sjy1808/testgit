package com.jt.sys.service;

import org.apache.ibatis.annotations.Param;

import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysLog;

public interface SysLogService {

	/**
	 * 通过此方法删除要删除的数据
	 * @param ids 要删除的数据的id数组
	 * @return
	 */
	int deleteObjects(Integer[] ids);
	/**
	 * 通过此方法实现分页查询操作
	 * @param name 基于条件查询时的参数名
	 * @param pageCurrent 当前的页码值
	 * @return 当前页记录+分页信息
	 */
	PageObject<SysLog> findPageObjects(String username,Integer pageCurrent);
}

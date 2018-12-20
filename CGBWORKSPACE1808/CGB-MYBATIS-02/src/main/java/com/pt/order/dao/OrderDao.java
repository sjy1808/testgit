package com.pt.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pt.order.entity.Order;
import com.pt.order.vo.OrderVo;
import com.pt.order.vo.SqlOrderCommand;

public interface OrderDao {

	List<OrderVo> findPageObjects(SqlOrderCommand cmd);
	/**
	 * 将订单的详细信息写入到数据库(对象的持久化)
	 * @param entity(封装了订单信息的对象)
	 * @return(写入数据的行数)
	 */
	int insertObject(Order entity);
	/**
	 * 基于id删除订单信息
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
	/**
	 * 基于多个id执行订单的删除操作
	 * @param ids
	 * @return
	 */
	int deleteObjectByIds(@Param("ids") String[] ids);
	
}

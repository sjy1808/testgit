package com.jt.order.manage.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Update;

import com.jt.common.mapper.SysMapper;
import com.jt.common.po.Order;

public interface OrderMapper extends SysMapper<Order> {

	@Update("update tb_order set status=6,updated=now() where status=1 and #{date}> created")
	void paymentOrder(Date date);
    
}
package com.jt.manage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jt.common.mapper.SysMapper;
import com.jt.common.po.Item;

public interface ItemMapper extends SysMapper<Item> {

	//使用注解的形式查询数据库
	@Select(value="select count(*) from tb_item")
	int findItemCount();
	/**
	 * mybatis不允许多值传参
	 * 1.将数据封装为(POJO)对象
	 * 2.将数据封装为Map集合
	 * 	@Param("start")Integer start将数据封装为map组合
	 * 3.将数据封装为 Array数组类型
	 * 4.将数据封装为List集合(arrayList)
	 * @param start
	 * @param rows
	 * @return
	 */
	List<Item> findItemByPage(@Param("start")Integer start, @Param("rows")Integer rows);
	
	@Select("select name from tb_item_cat where id=#{itemId}")
	String findItemCateNameById(Long itemId);
	
	void updateStatus(@Param("ids")Long[] ids, @Param("status")int status);

	
}

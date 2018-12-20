package com.jt.sso.manage.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jt.common.mapper.SysMapper;
import com.jt.common.po.User;

public interface UserMapper extends SysMapper<User> {

	//根据用户指定查询
	int selectCount1(@Param("param")String param, @Param("column")String column);

	@Select("select * from tb_user where username=#{username} and password=#{password}")
	User findUserByUP(User user);

	//暂时不维护,使用通用mapper
}

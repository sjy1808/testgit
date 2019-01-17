package com.jt.sso.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jt.sso.pojo.User;

public interface UserMapper {

	@Select("SELECT COUNT(1) FROM tb_user WHERE ${paramType} = #{param}")
    public Integer check(@Param("param") String param,@Param("paramType") String paramType);
	
	@Insert("INSERT INTO tb_user (id,username,password,phone,email,created,updated)VALUES(NULL,#{username},#{password},#{phone},#{email},NOW(),NOW())")
    public void save(User user);
    
	@Select("SELECT * FROM tb_user WHERE username = #{userName}")
	public User login(String userName);

}

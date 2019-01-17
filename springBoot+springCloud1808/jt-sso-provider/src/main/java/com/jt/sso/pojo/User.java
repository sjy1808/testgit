package com.jt.sso.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.jt.pojo.BasePojo;

//引入MybatisPlus,它能实现单表CRUD操作不写SQL语句,通用Mapper升级版本
@TableName("tb_user")//数据库表和类的映射
public class User extends BasePojo {

	private static final long serialVersionUID = 1L;
	@TableId(type=IdType.AUTO)//主键,自增主键
	private Long id;
	private String username;
	private String password;
	private String phone;
	private String email;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

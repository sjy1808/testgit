package com.tedu.ssm.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tedu.ssm.pojo.User;
//使用MybatisPlus后,继承BaseMapper接口,实现单表的CRUD SQL语句
public interface UserMapper extends BaseMapper<User> {

	//如果后续有补充,可以直接写
}

package com.tedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * JDBC快速入门程序
 */
public class JDBCDemo1 {
	public static void main(String[] args) throws Exception {
		//1.注册数据库驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//获取数据库连接
		Connection conn=DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/jt_db",//路径
				"root", //用户名
				"");//密码
		
		//3.获取传输器
		Statement stat=conn.createStatement();
		
		//4.利用传输器发送sql语句到数据库执行，返回执行结果
		String sql="select * from account";
		ResultSet rs=stat.executeQuery(sql);
		
		//5.处理结果(将结果集中的所有记录打印到控制台上)
		while(rs.next()){
			int id=rs.getInt("id");
			String name=rs.getString("name");
			double money=rs.getDouble("money");
			System.out.println(id+":"+name+":"+money);
		}
		
		//6.释放资源(越晚获取的，越早关闭)
		rs.close();
		stat.close();
		conn.close();
	}
}

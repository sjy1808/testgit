package com.tedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tedu.util.JDBCUtil;

/**
 * JDBC快速入门程序
 */
public class JDBCDemo2 {
	public static void main(String[] args) {
		//1.注册数据库驱动
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//DriverManager.registerDriver(new Driver);注册两次
			
			//获取数据库连接(用接口导包连接让程序更加通用)
			conn=DriverManager.getConnection(
					"jdbc:mysql:///jt_db",//路径   如果是默认的localhost:3306端口可以省略
					"root", //用户名
					"");//密码
			
			//3.获取传输器
			
			stat=conn.createStatement();
			
			//4.利用传输器发送sql语句到数据库执行，返回执行结果
			String sql="select * from account";
			rs=stat.executeQuery(sql);
			
			//5.处理结果(将结果集中的所有记录打印到控制台上)
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				double money=rs.getDouble("money");
				System.out.println(id+":"+name+":"+money);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("查询失败！");
		} finally {
			JDBCUtil.close(conn, stat, rs);
		}
	}
}

package com.tedu.c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.tedu.util.JDBCUtil;

public class TestC3P0 {
	public static void main(String[] args) {
		/*
		 * 需求：查询account表中id为1的记录，并打印在控制台中
		 */
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//!!创建一个连接池对象（c3p0）
		ComboPooledDataSource pool=new ComboPooledDataSource();
		try {
			//!!设置连接数据库的基本信息
			pool.setDriverClass("com.mysql.jdbc.Driver");
			pool.setJdbcUrl("jdbc:mysql:///jt_db");
			pool.setUser("root");
			pool.setPassword("");
			
			conn=pool.getConnection();//从连接池中获取一个连接对象
			String sql="select * from account where id=?";
			ps=conn.prepareStatement(sql);//获取传输器
			ps.setInt(1, 1);//设置参数
			rs=ps.executeQuery();//执行sql并返回执行结果，（）不要传sql
			//处理结果
			if(rs.next()){
				System.out.println(rs.getInt("id")+":"+rs.getString("name")+":"+rs.getDouble("money"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询失败");
		} finally {
			JDBCUtil.close(conn, ps, rs);
		}
	}
}

package com.tedu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	/**
	 * 获取连接对象并返回
	 * @return Connection 连接对象
	 * @throws Exception 
	 */
	public static Connection getConn() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jt_db?useUnicode=true&characterEncoding=utf-8","root","");
		return conn;
	}
	/**
	 * 释放连接对象、传输器、结果集资源
	 * @param conn 连接对象
	 * @param stat 传输器
	 * @param rs   结果集
	 */
	public static void close(Connection conn,Statement stat,ResultSet rs){

		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				rs=null;
			}
		}
		if(stat!=null){
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				stat=null;
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				conn=null;
			}
		}
	
	}
}

package com.tedu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC工具类
 */
public class JDBCUtil {
	/**
	 * 获取连接对象并返回
	 * @return Connection 连接对象
	 * @throws Exception
	 */
	public static Connection getConn() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql:///jt_db?useUnicode=true&characterEncoding=utf-8","root","");
		return conn;
	}
	/**
	 * 释放（连接对象、传输器、结果集）资源
	 * @param conn   连接对象
	 * @param stat   传输器
	 * @param rs	   结果集对象
	 */
	
	public  static void close(Connection conn,Statement stat,ResultSet rs){
		//释放资源
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
				e.printStackTrace();
			} finally {
				stat=null;
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn=null;
			}
		}
		
	}
}

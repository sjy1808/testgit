package com.tedu.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

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
		//读取配置文件中的配置信息
		Properties prop=new Properties();
		//通过流指向要读取的配置文件
		File file=new File("bin/conf.properties");
		InputStream in =new FileInputStream(file);
		//将配置文件中的配置信息读取到prop对象中
		prop.load(in);
		
		String driverClass=prop.getProperty("driverClass");
		String jdbcUrl=prop.getProperty("jdbcUrl");
		String user=prop.getProperty("user");
		String password=prop.getProperty("password");
		Class.forName(driverClass);
		Connection conn=DriverManager.getConnection(jdbcUrl,user,password);
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
				/*
				 * 如果conn连接对象是自己创建的连接对象，就是原生的连接对象，此时调用close方法则是将连接关闭还给数据库
				 * 如果Conn连接对象是从连接池中获取的，这个连接对象已经被改造过了，调用close方法则是将连接还给连接池
				 */
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn=null;
			}
		}
		
	}
}

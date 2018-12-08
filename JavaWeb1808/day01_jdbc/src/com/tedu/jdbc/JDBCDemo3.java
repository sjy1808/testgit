package com.tedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tedu.util.JDBCUtil;

public class JDBCDemo3 {
	public static void main(String[] args){
		add();
		delete();
		update();
	}

	private static void update() {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try {
			/*
			 * 1.注册数据库驱动
			 * 2.获取数据库连接
			 * 3.获取传输器
			 * 4.利用传输器发送sql到数据库执行，返回执行结果
			 * 5.处理结果
			 */
			/*Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql:///jt_db?useUnicode=true&characterEncoding=utf-8","root","");*/
			JDBCUtil.getConn();
			stat=conn.createStatement();
			String sql="Update account set money=14500 where id=8";
			int row=stat.executeUpdate(sql);
			System.out.println("影响了"+row+"行");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("修改信息失败！");
		} finally {
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
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

	private static void delete() {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try {
			/*
			 * 1.注册数据库驱动
			 * 2.获取数据库连接
			 * 3.获取传输器
			 * 4.利用传输器发送sql到数据库执行，返回执行结果
			 * 5，处理结果
			 */
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql:///jt_db?useUnicode=true&charaterEncoding=utf-8","root","");
			stat=conn.createStatement();
			String sql="Delete from account"+" where name='张飞'";
			int row=stat.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("删除信息失败！");
		} finally {
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
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

	public static void add() {
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try {
			//注册数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取数据库连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jt_db?useUnicode=true&characterEncoding=utf-8","root","");
			//获取传输器
			stat=conn.createStatement();
			//利用传输器发送sql到数据库执行，返回执行结果
			String sql="insert into account"+" values(null,'张三','4500')";
			int row=stat.executeUpdate(sql);
			//处理结果
			System.out.println("影响了"+row+"行");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("添加失败！");
		} finally {
			//释放资源
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
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
}

package com.tedu.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tedu.util.JDBCUtil;

public class JDBCDemo {
	public static void main(String[] args) {
		query();
		add();
		update();
		delete();
	}

	private static void delete() {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stat=null;
		try {
			conn=JDBCUtil.getConn();
			stat=conn.createStatement();
			String sql="delete from user where id=4 ";
			int row=stat.executeUpdate(sql);
			System.out.println("影响了一行");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("删除失败");
			
		} finally {
			JDBCUtil.close(conn, stat, null);
		}
	}

	private static void update() {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stat=null;
		try {
			conn=JDBCUtil.getConn();
			stat=conn.createStatement();
			String sql="Update user set password=123456 where id=3";
			int row=stat.executeUpdate(sql);
			System.out.println("影响了一行");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("修改失败");
			
		} finally {
			JDBCUtil.close(conn, stat, null);
		}
	}

	private static void add() {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stat=null;
		try {
			conn=JDBCUtil.getConn();
			stat=conn.createStatement();
			String sql="insert into user values(null,'tony','123') ";
			int row=stat.executeUpdate(sql);
			System.out.println("插入username为tony，密码为123的用户");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("插入失败！");
		} finally {
			JDBCUtil.close(conn, stat, null);
		}
	}

	private static void query() {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtil.getConn();
			stat=conn.createStatement();
			String sql="select * from user";
			rs=stat.executeQuery(sql);
			while(rs.next()){
				String username=rs.getString("username");
				String password=rs.getString("password");
				System.out.println(username+":"+password);
				
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

package com.tedu.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.tedu.util.JDBCUtil;

public class JDBCDemo1 {
	public static void main(String[] args) {
		query();
		add();
		update();
		delete();
	}

	private static void delete() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=JDBCUtil.getConn();
			String sql="delete from user where id=? ";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, 3);
			int row=ps.executeUpdate();
			System.out.println("影响了一行");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("删除失败");
			
		} finally {
			JDBCUtil.close(conn, ps, null);
		}
	}

	private static void update() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=JDBCUtil.getConn();
			String sql="Update user set password=? where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,"123456");
			ps.setInt(2, 1);
			int row=ps.executeUpdate();
			System.out.println("影响了一行");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("修改失败");
			
		} finally {
			JDBCUtil.close(conn, ps, null);
		}
	}

	private static void add() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=JDBCUtil.getConn();
			String sql="insert into user values(null,?,?)";
			ps=conn.prepareStatement(sql);
			//ps.setInt(1,6);
			
			ps.setString(1,"ben");
			ps.setString(2, "123");
			int row=ps.executeUpdate();
			System.out.println("插入username为ben，密码为123的用户");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("插入失败！");
		} finally {
			JDBCUtil.close(conn, ps, null);
		}
	}

	private static void query() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtil.getConn();
			String sql="select * from user";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery(sql);
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
			JDBCUtil.close(conn, ps, rs);
		}
	
	}
}

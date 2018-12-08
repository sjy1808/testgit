package com.tedu.c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.tedu.util.JDBCUtil;

public class Test1 {
	public static void main(String[] args) {
		add();
		delete();
		query();
		
	}

	private static void delete() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtil.getConn();
			String sql="Delete from product where name=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,"vivi21");
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("删除失败！");
		} finally {
			JDBCUtil.close(conn, ps, rs);
		}
		
	}

	private static void add() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtil.getConn();
			String sql="insert into product values(null,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, "vivi21");
			ps.setString(2, "手机数码");
			ps.setDouble(3, 2589);
			ps.setInt(4, 400);
			ps.setString(5, "照亮你的美！");
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("添加失败！");
		} finally {
			JDBCUtil.close(conn, ps, rs);
		}
	}

	private static void query() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ComboPooledDataSource pool = new ComboPooledDataSource();
		try {
			conn=JDBCUtil.getConn();
			String sql="select * from product";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt("id")+":"+rs.getString("name")+":"+rs.getDouble("price")+":"+rs.getString("pnum")+":"+rs.getString("description"));
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

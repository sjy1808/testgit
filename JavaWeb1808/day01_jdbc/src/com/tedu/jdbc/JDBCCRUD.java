package com.tedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC增删改查
 * CRUD：Create(增加)  Retrieve(查)  Update(改)  Delete(删除)
 */
public class JDBCCRUD {
	public static void main(String[] args) {
		//1.新增记录
		//add();
		//del();
		update();
	}
	/**
	 * 1.新增：往account表中插入一条记录，name为join,money为2000
	 */
	
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
			String sql="insert into account"+" values(null,'刘备',2000)";
			int row=stat.executeUpdate(sql);
			//处理结果
			System.out.println("影响了"+row+"行");
			/*String sql="select * from account";
			ResultSet rs=
			while(rs.){
				
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("添加失败！");
		} finally {
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
	/**
	 * 2.删除:删除第四行的记录
	 */
	
	public static void del() {
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
			String sql="Delete from account"+" where name='john'";
			int row=stat.executeUpdate(sql);
			//处理结果
			System.out.println("影响了"+row+"行");
			/*String sql="select * from account";
			ResultSet rs=
			while(rs.){
				
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("添加失败！");
		} finally {
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
	/**
	 * 3.修改：修改account表中id为3的记录
	 * 将金额修改为15000
	 * update account set money=15000 where id=3
	 */
	public static void update() {
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
			String sql="Update account "+" set money=15000 where id=3";
			int row=stat.executeUpdate(sql);
			//处理结果
			System.out.println("影响了"+row+"行");
			/*String sql="select * from account";
			ResultSet rs=
			while(rs.){
				
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("添加失败！");
		} finally {
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
}

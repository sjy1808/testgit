package com.tedu.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.tedu.util.JDBCUtil;

/**
 * 模拟用户登录
 */
public class LoginUser {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//提示用户登录
		System.out.println("请登录...");
		//提示用户输入用户名和密码
		System.out.println("请输入用户名：");
		String username=in.nextLine();
		System.out.println("请输入密码：");
		String password=in.nextLine();
		
		//调用方法，根据用户名和密码登录用户
		//login(username,password);
		loginByPs(username,password);
		
		
	}
	/**
	 * 根据用户名和密码实现登录操作
	 * @param username
	 * @param password
	 */
	private static void loginByPs(String username, String password) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtil.getConn();//获取连接
			//获取传输器
			String sql="select * from user where username=? and password=?";
			ps=conn.prepareStatement(sql);
			//设置sql参数
			ps.setString(1, username);
			ps.setString(2, password);
			//执行sql语句，返回执行结果
			rs=ps.executeQuery();//不要传sql参数！！
			
			//处理结果
			if(rs.next()){//true 用户名密码正确
				System.out.println("恭喜您登录成功！");
			}else {//false 用户名密码不正确
				System.out.println("用户名或密码不正确！！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("登录失败！");
		} finally {
			JDBCUtil.close(conn, ps, rs);
		}
	}
	/**
	 * 根据用户名和密码实现登录操作
	 * @param username
	 * @param password
	 */
	private static void login(String username, String password) {
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtil.getConn();//获取连接
			stat=conn.createStatement();//获取传输器
			String sql="select * from user where username='"+username+"' and password='"+password+"' ";
			rs=stat.executeQuery(sql);//执行SQL语句
			//处理结果
			if(rs.next()){//true 用户名密码正确
				System.out.println("恭喜您登录成功！");
			}else {//false 用户名密码不正确
				System.out.println("用户名或密码不正确！！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("登录失败！");
		} finally {
			JDBCUtil.close(conn, stat, rs);
		}
	}
}

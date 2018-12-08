package com.tedu.batch;

import java.sql.Connection;

import com.tedu.util.JDBCUtil;

public class Statement {
	public static void main(String[] args) {
		Connection conn=null;
		java.sql.Statement stat=null;
		try {
			conn=JDBCUtil.getConn();
			stat=conn.createStatement();
			stat.addBatch("drop table if exists batch");
			stat.addBatch("create table batch(id int primary key auto_increment, name varchar(50))");
			stat.addBatch("insert into batch values(null, 'test1')");
			stat.addBatch("insert into batch values(null, 'test2')");
			stat.addBatch("insert into batch values(null, 'test3')");
			stat.addBatch("insert into batch values(null, 'test4')");
			stat.addBatch("insert into batch values(null, 'test5')");
			stat.executeBatch();
			System.out.println("执行完成");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("执行失败");
		} finally {
			JDBCUtil.close(conn, stat, null);
		}
	}
	
}

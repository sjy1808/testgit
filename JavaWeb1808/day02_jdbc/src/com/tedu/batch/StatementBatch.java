package com.tedu.batch;

import java.sql.Connection;
import java.sql.Statement;

import com.tedu.util.JDBCUtil;

/**
 * 通过Statement对象实现批处理
 * create table batch(id int,name varchar(50));
 * insert into batch values(1,'a');
 * insert into batch values(2,'b');
 * insert into batch values(3,'c');
 * insert into batch values(4,'d');
 * insert into batch values(5,'e');
 * insert into batch values(6,'f');
 * insert into batch values(7,'g');
 * 
 */
public class StatementBatch {
	public static void main(String[] args) {
		Connection conn=null;
		Statement stat=null;
		try {
			conn =JDBCUtil.getConn();
			stat=conn.createStatement();
			//将现有的sql添加到批处理中
			stat.addBatch("create table batch(id int,name varchar(50))");
			stat.addBatch("insert into batch values(1,'a')");
			stat.addBatch("insert into batch values(2,'b')");
			stat.addBatch("insert into batch values(3,'c')");
			stat.addBatch("insert into batch values(4,'d')");
			stat.addBatch("insert into batch values(5,'e')");
			stat.addBatch("insert into batch values(6,'f')");
			stat.addBatch("insert into batch values(7,'g')");
			
			//将批处理一次性发送到数据库执行
			stat.executeBatch();
			
			System.out.println("执行完成！");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("执行失败！");
		} finally {
			JDBCUtil.close(conn, stat, null);
		}
	}
}

package com.tedu.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.tedu.util.JDBCUtil;

/**
 * 通过PreparedStatement对象实现批处理
 * 需求：往batch表中插入1000条记录
 */
public class PSBatch {
	public static void main(String[] args) {
		add();
		//delete();
	}

	private static void delete() {
		// TODO Auto-generated method stub

		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=JDBCUtil.getConn();
			//将JDBC自动提交事务关闭掉
			conn.setAutoCommit(false);//不会每执行一次，保存一次
			
			
			//记录开始时间
			long begin=System.currentTimeMillis();
			String sql="Delete from batch where id=?";
			ps=conn.prepareStatement(sql);
			//将sql语句的参数添加到批处理中
			
			//删除
			for(int i=1;i<=1000;i++){
				ps.setInt(1, i);
				ps.addBatch();
			}
			//将批处理发送到数据库执行
			ps.executeBatch();
			
			//手动提交事务（仅提交一次）
			conn.commit();
			//记录结束时间
			long end=System.currentTimeMillis();
			double time=(end-begin)/1000.0;
			System.out.println("执行完成！,耗时："+time+"秒");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("执行失败");
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
			//将JDBC自动提交事务关闭掉
			conn.setAutoCommit(false);//不会每执行一次，保存一次
			
			
			//记录开始时间
			long begin=System.currentTimeMillis();
			String sql="insert into batch values(?,?)";
			ps=conn.prepareStatement(sql);
			//将sql语句的参数添加到批处理中
			for(int i=1;i<=1000;i++){
				ps.setInt(1, i+5);
				ps.setString(2, "test"+i);
				ps.addBatch();
			}
			
			//将批处理发送到数据库执行
			ps.executeBatch();
			
			//手动提交事务（仅提交一次）
			conn.commit();
			//记录结束时间
			long end=System.currentTimeMillis();
			double time=(end-begin)/1000.0;
			System.out.println("执行完成！,耗时："+time+"秒");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("执行失败");
		} finally {
			JDBCUtil.close(conn, ps, null);
		}
	
	}
}

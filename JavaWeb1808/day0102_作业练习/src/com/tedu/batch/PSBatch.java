package com.tedu.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tedu.util.JDBCUtil;

public class PSBatch {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtil.getConn();
			for(int i=7;i<=200;i++){
				String sql="insert into batch values(null,?)";
				ps=conn.prepareStatement(sql);
				ps.setString(1, "test6");
				ps.executeUpdate();
			}
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("执行失败");
		} finally {
			JDBCUtil.close(conn, ps, null);
		}
	}
}

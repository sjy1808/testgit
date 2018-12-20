package com.pt.member.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pt.member.dao.MemberDao;

public class MemberDaoImpl implements MemberDao {

	@Override
	public List<Map<String, Object>> findMembers() {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(
					"jdbc:mysql:///tcgbtms",
					"root",
					"");
			stmt=conn.createStatement();
			String sql="select * from t_members";
			rs=stmt.executeQuery(sql);
			//描述原数据的数据
			ResultSetMetaData rsmd=rs.getMetaData();
			List<Map<String,Object>> list=new ArrayList<>();
			while(rs.next()){
				rowMap(rs, rsmd, list);
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if(rs!=null)try { rs.close();} catch (Exception e) {}
			if(stmt!=null)try { stmt.close();} catch (Exception e) {}
			if(conn!=null)try { conn.close();} catch (Exception e) {}
		}
		
	}

	private void rowMap(ResultSet rs, ResultSetMetaData rsmd, List<Map<String, Object>> list) throws SQLException {
		Map<String,Object> map=new HashMap<>();
		/*map.put("id",rs.getString("id"));
		map.put("nickname",rs.getString("nickname"));
		map.put("realname",rs.getString("realname"));
		map.put("rank",rs.getString("rank"));*/
		int columnCount=rsmd.getColumnCount();
		for(int i=1;i<columnCount;i++){
			map.put(rsmd.getColumnLabel(i), rs.getObject(i));
		}
		list.add(map);
	}

}

package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.ProChart;
import com.dao.ProChartDao;
import com.util.JdbcUtil;

public class ProChartDaoImpl implements ProChartDao{
	/***
	 * 获取项目等级信息
	 */
    
	@Override
	public List<ProChart> query() {
		ArrayList<ProChart> proChartList = new ArrayList<ProChart>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql = " select * from prochart";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				ProChart proChart = new ProChart();
				proChart.setLevel(rs.getString("level"));
				proChart.setNum(rs.getInt("num"));
				proChartList.add(proChart);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return proChartList;

	}
	
}

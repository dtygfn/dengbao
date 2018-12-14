package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.PerChart;
import com.dao.PerChartDao;
import com.util.JdbcUtil;

public class PerChartDaoImpl implements PerChartDao{

	@Override
	public List<PerChart> query() {
			ArrayList<PerChart> perChartList = new ArrayList<PerChart>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try{
				conn = JdbcUtil.getConnection();
				String sql = " select * from perchart";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()){
					PerChart perChart = new PerChart();
					perChart.setTitle(rs.getString("title"));
					perChart.setNum(rs.getInt("num"));
					perChartList.add(perChart);
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				JdbcUtil.close(conn, pstmt, rs);
			}
			
			return perChartList;
	}

}

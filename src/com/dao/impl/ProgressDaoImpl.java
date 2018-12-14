package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bean.Progress;
import com.constants.Constants;
import com.dao.ProgressDao;
import com.util.JdbcUtil;

public class ProgressDaoImpl implements ProgressDao{

	@Override
	public List<Progress> getProgressList(int offset) {
		List<Progress> progressList = new ArrayList<Progress>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql = " select * from progress limit ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, offset);
			pstmt.setInt(2, Constants.MAX_PAGE_COUNT);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Progress progress = new Progress();
				progress.setProjectid(rs.getString("projectid"));
				progress.setName(rs.getString("name"));
				progress.setEartime(rs.getString("earTime"));
				progress.setEarprogress(rs.getString("earprogress"));
				progress.setMidtime(rs.getString("midTime"));
                progress.setMidprogress(rs.getString("midprogress"));				
				progress.setLatetime(rs.getString("lateTime"));
				progress.setLateprogress(rs.getString("lateprogress"));				
				progress.setProgress(rs.getString("progress"));				
				progress.setEndtime(rs.getString("endTime"));
				progress.setResult(rs.getString("result"));
				progressList.add(progress);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt, rs);
		}
		return progressList;
	}

	@Override
	public void deleteProgress(String projectid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "delete from progress where projectid=?";
			pstmt = JdbcUtil.getPreparedStatement(conn, sql);
			pstmt.setString(1, projectid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt);
		}		
	}

	@Override
	public void updateProgress(Progress progress, String projectid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "update progress set projectid=?,name=?,eartime=?,earprogress=?,midtime=?,midprogress=?,latetime=?,lateprogress=?,progress=?,endtime=?,result=? where projectid="+"'"+projectid+"'";
			pstmt = JdbcUtil.getPreparedStatement(conn, sql);
			pstmt.setString(1, progress.getProjectid());
			pstmt.setString(2, progress.getName());
			pstmt.setString(3, progress.getEartime());
			pstmt.setString(4, progress.getEarprogress());
			pstmt.setString(5, progress.getMidtime());
			pstmt.setString(6, progress.getMidprogress());
			pstmt.setString(7, progress.getLatetime());
			pstmt.setString(8, progress.getLateprogress());
			pstmt.setString(9, progress.getProgress());
			pstmt.setString(10, progress.getEndtime());
			pstmt.setString(11, progress.getResult());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt);
		}				
	}

	@Override
	public Progress queryByProjectid(String projectid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Progress progress= new Progress();
		try{
			conn = JdbcUtil.getConnection();
			String sql = " select * from progress where projectid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, projectid);
			rs = pstmt.executeQuery();
			if(rs.next()){
				progress.setProjectid(rs.getString("projectid"));
				progress.setName(rs.getString("name"));
				progress.setEartime(rs.getString("earTime"));
				progress.setEarprogress(rs.getString("earprogress"));
				progress.setMidtime(rs.getString("midTime"));
                progress.setMidprogress(rs.getString("midprogress"));				
				progress.setLatetime(rs.getString("lateTime"));
				progress.setLateprogress(rs.getString("lateprogress"));				
				progress.setProgress(rs.getString("progress"));				
				progress.setEndtime(rs.getString("endTime"));
				progress.setResult(rs.getString("result"));
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt, rs);
		}
		return progress;
	}

	@Override
	public void addProgress(Progress progress) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = " insert into progress values (?,?,?,?,?,?,?,?,?,?,?)";
			
			pstmt = JdbcUtil.getPreparedStatement(conn, sql);
			pstmt.setString(1, progress.getProjectid());
			pstmt.setString(2, progress.getName());
			pstmt.setString(3, progress.getEartime());
			pstmt.setString(4, progress.getEarprogress());
			pstmt.setString(5, progress.getMidtime());
			pstmt.setString(6, progress.getMidprogress());
			pstmt.setString(7, progress.getLatetime());
			pstmt.setString(8, progress.getLateprogress());
			pstmt.setString(9, progress.getProgress());
			pstmt.setString(10, progress.getEndtime());
			pstmt.setString(11, progress.getResult());			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt);
		}
				
	}

	@Override
	public int getCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = JdbcUtil.getConnection();
			String sql = " select count(*) count from progress";
			pstmt = JdbcUtil.getPreparedStatement(conn, sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt, rs);
		}
		return count;
	}

	@Override
	public List<Progress> selectProgress(int offset, String select, String neirong) {
		List<Progress> progressList = new ArrayList<Progress>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql = " select * from progress where "+select+"='"+neirong+"'limit ?,?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, offset);
			pstmt.setInt(2, Constants.MAX_PAGE_COUNT);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Progress progress = new Progress();
				
				progress.setProjectid(rs.getString("projectid"));
				progress.setName(rs.getString("name"));
				progress.setEartime(rs.getString("earTime"));
				progress.setEarprogress(rs.getString("earprogress"));
				progress.setMidtime(rs.getString("midTime"));
                progress.setMidprogress(rs.getString("midprogress"));				
				progress.setLatetime(rs.getString("lateTime"));
				progress.setLateprogress(rs.getString("lateprogress"));				
				progress.setProgress(rs.getString("progress"));				
				progress.setEndtime(rs.getString("endTime"));
				progress.setResult(rs.getString("result"));
				progressList.add(progress);
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt, rs);
		}
		return progressList;

	}

	@Override
	public int getSelectCount(String select, String neirong) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = JdbcUtil.getConnection();
			String sql = " select count(*) from progress where "+select+"='"+neirong+"' ";
			pstmt = JdbcUtil.getPreparedStatement(conn, sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt, rs);
		}
		return count;
	}


	@Override
	public List<Progress> getEarProgressList(int offset,String username) {
		List<Progress> progressList = new ArrayList<Progress>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql = " select projectid,name,eartime,earprogress from progress where projectid in (SELECT projectid from eartask where person=(select workername from person where workerid = '"+username+"') ) limit ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, offset);
			pstmt.setInt(2, Constants.MAX_PAGE_COUNT);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Progress progress = new Progress();
				progress.setProjectid(rs.getString("projectid"));
				progress.setName(rs.getString("name"));
				progress.setEartime(rs.getString("earTime"));
				progress.setEarprogress(rs.getString("earprogress"));
				progressList.add(progress);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt, rs);
		}
		return progressList;
	}

	@Override
	public List<Progress> getMidProgressList(int offset, String username) {
		List<Progress> progressList = new ArrayList<Progress>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql = " select projectid,name,midtime,midprogress from progress where projectid in (SELECT projectid from midtask where person=(select workername from person where workerid = '"+username+"') ) limit ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, offset);
			pstmt.setInt(2, Constants.MAX_PAGE_COUNT);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Progress progress = new Progress();
				progress.setProjectid(rs.getString("projectid"));
				progress.setName(rs.getString("name"));
				progress.setEartime(rs.getString("midTime"));
				progress.setEarprogress(rs.getString("midprogress"));
				progressList.add(progress);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt, rs);
		}
		return progressList;
	}

	@Override
	public List<Progress> getLateProgressList(int offset, String username) {
		List<Progress> progressList = new ArrayList<Progress>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql = " select projectid,name,latetime,lateprogress from progress where projectid in (SELECT projectid from latetask where person=(select workername from person where workerid = '"+username+"') ) limit ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, offset);
			pstmt.setInt(2, Constants.MAX_PAGE_COUNT);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Progress progress = new Progress();
				progress.setProjectid(rs.getString("projectid"));
				progress.setName(rs.getString("name"));
				progress.setEartime(rs.getString("lateTime"));
				progress.setEarprogress(rs.getString("lateprogress"));
				progressList.add(progress);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt, rs);
		}
		return progressList;
	}

	@Override
	public Progress earqueryByProjectid(String projectid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Progress progress= new Progress();
		try{
			conn = JdbcUtil.getConnection();
			String sql = " select * from earprogress where projectid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, projectid);
			rs = pstmt.executeQuery();
			if(rs.next()){
				progress.setProjectid(rs.getString("projectid"));
				progress.setName(rs.getString("name"));
				progress.setEartime(rs.getString("time"));
				progress.setEarprogress(rs.getString("progress"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt, rs);
		}
		return progress;
	}

	@Override
	public Progress midqueryByProjectid(String projectid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Progress progress= new Progress();
		try{
			conn = JdbcUtil.getConnection();
			String sql = " select * from midprogress where projectid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, projectid);
			rs = pstmt.executeQuery();
			if(rs.next()){
				progress.setProjectid(rs.getString("projectid"));
				progress.setName(rs.getString("name"));
				progress.setEartime(rs.getString("time"));
				progress.setEarprogress(rs.getString("progress"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt, rs);
		}
		return progress;
	}

	@Override
	public Progress latequeryByProjectid(String projectid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Progress progress= new Progress();
		try{
			conn = JdbcUtil.getConnection();
			String sql = " select * from lateprogress where projectid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, projectid);
			rs = pstmt.executeQuery();
			if(rs.next()){
				progress.setProjectid(rs.getString("projectid"));
				progress.setName(rs.getString("name"));
				progress.setEartime(rs.getString("time"));
				progress.setEarprogress(rs.getString("progress"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt, rs);
		}
		return progress;
	}

	@Override
	public void updateEarProgress(Progress progress, String projectid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "update earprogress set projectid=?,name=?,time=?,progress=? where projectid="+"'"+projectid+"'";
			pstmt = JdbcUtil.getPreparedStatement(conn, sql);
			pstmt.setString(1, progress.getProjectid());
			pstmt.setString(2, progress.getName());
			pstmt.setString(3, progress.getEartime());
			pstmt.setString(4, progress.getEarprogress());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt);
		}				
		
	}

	@Override
	public void updateMidProgress(Progress progress, String projectid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "update midprogress set projectid=?,name=?,time=?,progress=? where projectid="+"'"+projectid+"'";
			pstmt = JdbcUtil.getPreparedStatement(conn, sql);
			pstmt.setString(1, progress.getProjectid());
			pstmt.setString(2, progress.getName());
			pstmt.setString(3, progress.getEartime());
			pstmt.setString(4, progress.getEarprogress());
			pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				JdbcUtil.close(conn, pstmt);
			}				
		
	}

	@Override
	public void updateLateProgress(Progress progress, String projectid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "update lateprogress set projectid=?,name=?,time=?,progress=? where projectid="+"'"+projectid+"'";
			pstmt = JdbcUtil.getPreparedStatement(conn, sql);
			pstmt.setString(1, progress.getProjectid());
			pstmt.setString(2, progress.getName());
			pstmt.setString(3, progress.getEartime());
			pstmt.setString(4, progress.getEarprogress());
			pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				JdbcUtil.close(conn, pstmt);
			}				
	}


}

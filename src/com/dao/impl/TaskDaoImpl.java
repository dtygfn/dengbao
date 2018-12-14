package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Task;
import com.constants.Constants;
import com.dao.TaskDao;
import com.util.JdbcUtil;

public class TaskDaoImpl implements TaskDao{

	@Override
	public List<Task> getTaskList(int offset) {
		List<Task> taskList = new ArrayList<Task>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql = " select * from task limit ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, offset);
			pstmt.setInt(2, Constants.MAX_PAGE_COUNT);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Task task = new Task();
				task.setProjectid(rs.getString("projectid"));
				task.setName(rs.getString("name"));
				task.setEarly(rs.getString("early"));
				task.setEarperson(rs.getString("earperson"));
				task.setMiddle(rs.getString("middle"));
				task.setMidperson(rs.getString("midperson"));
				task.setLate(rs.getString("late"));
				task.setLateperson(rs.getString("lateperson"));
				task.setLeader(rs.getString("leader"));
				taskList.add(task);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt, rs);
		}
		return taskList;
	}

	@Override
	public void deleteTask(String projectid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "delete from task where projectid=?";
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
	public void updateTask(Task task, String projectid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "update task set projectid=?,name=?,early=?,earperson=?,middle=?,midperson=?,late=?,lateperson=?,leader=? where projectid="+"'"+projectid+"'";
			pstmt = JdbcUtil.getPreparedStatement(conn, sql);
			pstmt.setString(1, task.getProjectid());
			pstmt.setString(2, task.getName());
			pstmt.setString(3, task.getEarly());
			pstmt.setString(4, task.getEarperson());
			pstmt.setString(5, task.getMiddle());
			pstmt.setString(6, task.getMidperson());
			pstmt.setString(7, task.getLate());
			pstmt.setString(8, task.getLateperson());
			pstmt.setString(9, task.getLeader());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt);
		}		
	}

	@Override
	public Task queryByProjectid(String projectid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Task task= new Task();
		try{
			conn = JdbcUtil.getConnection();
			String sql = " select * from task where projectid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, projectid);
			rs = pstmt.executeQuery();
			if(rs.next()){
				task.setProjectid(rs.getString("projectid"));
				task.setName(rs.getString("name"));
				task.setEarly(rs.getString("early"));
				task.setEarperson(rs.getString("earperson"));
				task.setMiddle(rs.getString("middle"));
				task.setMidperson(rs.getString("midperson"));
				task.setLate(rs.getString("late"));
				task.setLateperson(rs.getString("lateperson"));
				task.setLeader(rs.getString("leader"));
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt, rs);
		}
		return task;
	}

	@Override
	public void addTask(Task task) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = " insert into task values (?,?,?,?,?,?,?,?,?)";
			pstmt = JdbcUtil.getPreparedStatement(conn, sql);
			pstmt.setString(1, task.getProjectid());
			pstmt.setString(2, task.getName());
			pstmt.setString(3, task.getEarly());
			pstmt.setString(4, task.getEarperson());
			pstmt.setString(5, task.getMiddle());
			pstmt.setString(6, task.getMidperson());
			pstmt.setString(7, task.getLate());
			pstmt.setString(8, task.getLateperson());
			pstmt.setString(9, task.getLeader());
			
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
			String sql = " select count(*) count from task";
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
	public List<Task> selectTask(int offset, String select, String neirong) {
		List<Task> taskList = new ArrayList<Task>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql = " select * from task where "+select+"='"+neirong+"'limit ?,?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, offset);
			pstmt.setInt(2, Constants.MAX_PAGE_COUNT);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Task task = new Task();
				
				task.setProjectid(rs.getString("projectid"));
				task.setName(rs.getString("name"));
				task.setEarly(rs.getString("early"));
				task.setEarperson(rs.getString("earperson"));
				task.setMiddle(rs.getString("middle"));
				task.setMidperson(rs.getString("midperson"));
				task.setLate(rs.getString("late"));
				task.setLateperson(rs.getString("lateperson"));
				task.setLeader(rs.getString("leader"));
				
				taskList.add(task);
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt, rs);
		}
		return taskList;
	}

	@Override
	public int getSelectCount(String select, String neirong) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = JdbcUtil.getConnection();
			String sql = " select count(*) from task where "+select+"='"+neirong+"' ";
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
	public List<Task> getEarTaskList(int offset,String username) {
		List<Task> taskList = new ArrayList<Task>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql = " select projectid,name,task,person from eartask where person = (select workername from person where workerid = '"+username+"') limit ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, offset);
			pstmt.setInt(2, Constants.MAX_PAGE_COUNT);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Task task = new Task();
				task.setProjectid(rs.getString("projectid"));
				task.setName(rs.getString("name"));
				task.setEarly(rs.getString("task"));
				task.setEarperson(rs.getString("person"));
				
				taskList.add(task);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt, rs);
		}
		return taskList;
	}

	@Override
	public List<Task> getMidTaskList(int offset, String username) {
		List<Task> taskList = new ArrayList<Task>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql = " select projectid,name,task,person from midtask where person = (select workername from person where workerid = '"+username+"') limit ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, offset);
			pstmt.setInt(2, Constants.MAX_PAGE_COUNT);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Task task = new Task();
				task.setProjectid(rs.getString("projectid"));
				task.setName(rs.getString("name"));
				task.setEarly(rs.getString("task"));
				task.setEarperson(rs.getString("person"));

				taskList.add(task);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt, rs);
		}
		return taskList;	}

	@Override
	public List<Task> getLateTaskList(int offset, String username) {
		List<Task> taskList = new ArrayList<Task>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql = " select projectid,name,task,person from latetask where person = (select workername from person where workerid = '"+username+"') limit ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, offset);
			pstmt.setInt(2, Constants.MAX_PAGE_COUNT);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Task task = new Task();
				task.setProjectid(rs.getString("projectid"));
				task.setName(rs.getString("name"));
				task.setEarly(rs.getString("task"));
				task.setEarperson(rs.getString("person"));
				
				taskList.add(task);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt, rs);
		}
		return taskList;
	}

	@Override
	public int getEarCount(String username) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = JdbcUtil.getConnection();
			String sql = " select count(*) count from eartask where person = (select workername from person where workerid = '"+username+"')";
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
	public int getMidCount(String username) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = JdbcUtil.getConnection();
			String sql = " select count(*) count from midtask where person = (select workername from person where workerid = '"+username+"')";
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
	public int getLateCount(String username) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = JdbcUtil.getConnection();
			String sql = " select count(*) count from latetask where person = (select workername from person where workerid = '"+username+"')";
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
}

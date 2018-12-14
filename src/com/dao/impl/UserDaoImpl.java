package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.constants.Constants;
import com.dao.UserDao;
import com.util.JdbcUtil;
import com.bean.User;

public class UserDaoImpl implements UserDao{

	@Override
	public User login(String username,String password) {
		User user = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = " select * from users where username=? and password=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()){
				user = new User();
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setName(rs.getString(3));
				user.setJurisdiction(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt, rs);
		}
		return user;
	}

	@Override
	public List<User> getUserList(int offset) {
		List<User> userList = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql = " select * from users limit ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, offset);
			pstmt.setInt(2, Constants.MAX_PAGE_COUNT);
			rs = pstmt.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				if(rs.getString("jurisdiction").equals("0"))
                    user.setJurisdiction("管理员");
				else if(rs.getString("jurisdiction").equals("1"))
					 user.setJurisdiction("普通用户");
				userList.add(user);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt, rs);
		}
		return userList;
	}

	@Override
	public int getCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = JdbcUtil.getConnection();
			String sql = " select count(*) count from users ";
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
	public void deleteUser(String username) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = " delete from users where username=?";
			pstmt = JdbcUtil.getPreparedStatement(conn, sql);
			pstmt.setString(1,username);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt);
		}
		
	}

	@Override
	public void updateUser(User user, String username) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = " update users set password=?,name=?,jurisdiction=? where username="+"'"+username+"'";
			
			pstmt = JdbcUtil.getPreparedStatement(conn, sql);
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getJurisdiction());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt);
		}
	}

	@Override
	public User queryByUsername(String username) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = new User();
		try{
			conn = JdbcUtil.getConnection();
			String sql = " select * from users where username=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if(rs.next()){
				user.setUsername(username);
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				if(rs.getString("jurisdiction").equals("0"))
                    user.setJurisdiction("管理员");
				else if(rs.getString("jurisdiction").equals("1"))
					 user.setJurisdiction("普通用户");
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt, rs);
		}
		return user;
	}

	@Override
	public void addUser(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = " insert into users values(?,?,?,?)";
			pstmt = JdbcUtil.getPreparedStatement(conn, sql);
			pstmt.setString(1,user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getJurisdiction());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt);
		}
		
	}

	@Override
	public List<User> selectUser(int offset, String select, String neirong) {
		List<User> userList = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql = " select * from users where "+select+"='"+neirong+"'limit ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, offset);
			pstmt.setInt(2, Constants.MAX_PAGE_COUNT);
			rs = pstmt.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				if(rs.getString("jurisdiction").equals("0"))
                    user.setJurisdiction("管理员");
				else if(rs.getString("jurisdiction").equals("1"))
					 user.setJurisdiction("普通用户");
				
				userList.add(user);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt, rs);
		}
		return userList;
	}

	@Override
	public int getSelectCount(String select, String neirong) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = JdbcUtil.getConnection();
			String sql = " select count(*) from users where "+select+"='"+neirong+"' ";
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

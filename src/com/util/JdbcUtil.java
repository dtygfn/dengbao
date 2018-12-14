package com.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
	static String url = null;
	static String userName = null;
	static String password = null;
	static{
		try {
			Properties prop = new JdbcUtil().loadProperties();
			Class.forName(prop.getProperty("driver"));
			url = prop.getProperty("url");
			userName = prop.getProperty("userName");
			password = prop.getProperty("password");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Properties loadProperties(){
		Properties prop = new Properties();
		try {
			prop.load(this.getClass().getClassLoader().getResourceAsStream("jdbcProperties.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	/**
	 * 获取连接
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static PreparedStatement getPreparedStatement(Connection conn,String sql){
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}
	/**
	 * 查询方法
	 */
	public static ResultSet getResultSet(PreparedStatement pstmt){
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	/**
	 * 添加删除修改
	 * @param pstmt
	 * @return
	 */
	public static boolean addUpdateDel(PreparedStatement pstmt){
		boolean res = false;
		try {
			pstmt.executeUpdate();
			res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * 关闭资源
	 * @param args
	 */
	public static void close(Connection conn,PreparedStatement pstmt,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection conn,PreparedStatement pstmt){
		try {
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new JdbcUtil().loadProperties();
		
	}
}

package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Person;
import com.constants.Constants;
import com.dao.PersonDao;
import com.util.JdbcUtil;
/**
 * 员工类Dao层实现
 */
 
public class PersonDaoImpl implements PersonDao{

		/**
		 * 获取员工信息列表
		 */
		public List<Person> getPersonList(int offset) {
			List<Person> psonList = new ArrayList<Person>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try{
				conn = JdbcUtil.getConnection();
				String sql = " select * from person limit ?,?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, offset);
				pstmt.setInt(2, Constants.MAX_PAGE_COUNT);
				rs = pstmt.executeQuery();
				while(rs.next()){
					Person pson = new Person();
					pson.setWorkerid(rs.getString("workerid"));
					pson.setWorkername(rs.getString("workername"));
					pson.setAge(rs.getInt("age"));
					pson.setSex(rs.getString("sex"));
					pson.setTitle(rs.getString("title"));
					pson.setTeleno(rs.getString("teleno"));
					pson.setEmail(rs.getString("email"));
					
					psonList.add(pson);
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				JdbcUtil.close(conn, pstmt, rs);
			}
			return psonList;
		}
		 
			/**
			 * 删除员工信息
			 */
			public void deletePerson(String workerid) {
				Connection conn = null;
				PreparedStatement pstmt = null;
				try {
					conn = JdbcUtil.getConnection();
					String sql = " delete from person where workerid=?";
					pstmt = JdbcUtil.getPreparedStatement(conn, sql);
					pstmt.setString(1,workerid);
					pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					JdbcUtil.close(conn, pstmt);
				}
			}
			
			
			/**
			 * 更新员工信息列表
			 * @param pson
			 * @param workerid
			 */
			
		
		public void updatePerson(Person pson,String workerid) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = JdbcUtil.getConnection();
				String sql = " update person set workername=?,age=?,sex=?,title=?,teleno=?,email=? where workerid="+"'"+workerid+"'";
				
				pstmt = JdbcUtil.getPreparedStatement(conn, sql);
				pstmt.setString(1, pson.getWorkername());
				pstmt.setInt(2, pson.getAge());
				pstmt.setString(3, pson.getSex());
				pstmt.setString(4, pson.getTitle());
				pstmt.setString(5, pson.getTeleno());
				pstmt.setString(6, pson.getEmail());
				
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				JdbcUtil.close(conn, pstmt);
			}
		}
			
		/***
		 * 根据workerid进行查询员工信息
		 * @param workerid
		 * @return
		 */
	
		public Person queryByWorkerid(String workerid) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			Person pson = new Person();
			try{
				conn = JdbcUtil.getConnection();
				String sql = " select * from person where workerid=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, workerid);
				rs = pstmt.executeQuery();
				if(rs.next()){
					pson.setWorkerid(workerid);
					pson.setWorkername(rs.getString("workername"));
					pson.setAge(rs.getInt("age"));
					pson.setSex(rs.getString("sex"));
					pson.setTitle(rs.getString("title"));
					pson.setTeleno(rs.getString("teleno"));
					pson.setEmail(rs.getString("email"));
					
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				JdbcUtil.close(conn, pstmt, rs);
			}
			return pson;
		
		}
		/***
		 * 添加员工信息
		 * @param pson
		 */
		
		public void addPerson(Person pson) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = JdbcUtil.getConnection();
				String sql = " insert into person values(?,?,?,?,?,?,?)";
				pstmt = JdbcUtil.getPreparedStatement(conn, sql);
				pstmt.setString(1,pson.getWorkerid());
				pstmt.setString(2, pson.getWorkername());
				pstmt.setInt(3, pson.getAge());
				pstmt.setString(4, pson.getSex());
				pstmt.setString(5, pson.getTitle());
				pstmt.setString(6, pson.getTeleno());
				pstmt.setString(7, pson.getEmail());
			
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				JdbcUtil.close(conn, pstmt);
			}
			
		}
		/**
		 * 获取员工信息条数
		 * @return
		 */
		
		public int getCount() {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int count = 0;
			try {
				conn = JdbcUtil.getConnection();
				String sql = " select count(*) count from person";
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
		
		/**
		 * 根据条件查询员工信息
		 */
		public List<Person> selectPerson(int offset,String select,String neirong) {
			List<Person> psonList = new ArrayList<Person>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try{
				conn = JdbcUtil.getConnection();
				String sql = " select * from person where "+select+"='"+neirong+"'limit ?,?";
				pstmt = conn.prepareStatement(sql);
				/*pstmt.setString(1, select);
				pstmt.setString(2, neirong);
				pstmt.setInt(3, offset);
				pstmt.setInt(4, Constants.MAX_PAGE_COUNT);*/
				pstmt.setInt(1, offset);
				pstmt.setInt(2, Constants.MAX_PAGE_COUNT);
				rs = pstmt.executeQuery();
				while(rs.next()){
					Person pson = new Person();
					pson.setWorkerid(rs.getString("workerid"));
					pson.setWorkername(rs.getString("workername"));
					pson.setAge(rs.getInt("age"));
					pson.setSex(rs.getString("sex"));
					pson.setTitle(rs.getString("title"));
					pson.setTeleno(rs.getString("teleno"));
					pson.setEmail(rs.getString("email"));
					
					psonList.add(pson);
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				JdbcUtil.close(conn, pstmt, rs);
			}
			return psonList;
		}

		
		/**
		 * 获取根据条件查询后的员工个数
		 */
		public int getSelectCount(String select, String neirong) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int count = 0;
			try {
				conn = JdbcUtil.getConnection();
				String sql = " select count(*) from person where "+select+"='"+neirong+"' ";
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

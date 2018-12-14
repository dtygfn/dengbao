package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Project;
import com.constants.Constants;
import com.dao.ProjectDao;
import com.util.JdbcUtil;

/**
 * 项目类Dao层实现
 * @author 12149
 *
 */

public class ProjectDaoImpl implements ProjectDao{
         /**
		 * 显示项目信息
		 */
	 public List<Project> getProjectList(int offset) {
			List<Project> proList = new ArrayList<Project>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try{
				conn = JdbcUtil.getConnection();
				String sql = " select * from project limit ?,?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, offset);
				pstmt.setInt(2, Constants.MAX_PAGE_COUNT);
				rs = pstmt.executeQuery();
				while(rs.next()){
					Project pro = new Project();
					pro.setProjectid(rs.getString("projectid"));
					pro.setName(rs.getString("name"));
					pro.setInstitution(rs.getString("institution"));
					pro.setLevel(rs.getString("level"));
					pro.setFunds(rs.getString("funds"));
					pro.setManager(rs.getString("manager"));
					pro.setPhonenum(rs.getString("phonenum"));
					proList.add(pro);
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				JdbcUtil.close(conn, pstmt, rs);
			}
			return proList;
		}
	 
			/**
			 * 删除项目信息
			 */
			public void deleteProject(String projectid) {
				Connection conn = null;
				PreparedStatement pstmt = null;
				try {
					conn = JdbcUtil.getConnection();
					String sql = "delete from project where projectid=?";
					pstmt = JdbcUtil.getPreparedStatement(conn, sql);
					pstmt.setString(1, projectid);
					pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					JdbcUtil.close(conn, pstmt);
				}
			}
		/**
		 * 更新项目信息
		 */
		public void updateProject(Project pro,String projectid) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = JdbcUtil.getConnection();
				String sql = "update project set projectid=?,name=?,institution=?,level=?,funds=?,manager=?,phonenum=? where projectid="+"'"+projectid+"'";
				pstmt = JdbcUtil.getPreparedStatement(conn, sql);
				pstmt.setString(1, pro.getProjectid());
				pstmt.setString(2, pro.getName());
				pstmt.setString(3, pro.getInstitution());
				pstmt.setString(4, pro.getLevel());
				pstmt.setString(5, pro.getFunds());
				pstmt.setString(6, pro.getManager());
				pstmt.setString(7, pro.getPhonenum());

				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				JdbcUtil.close(conn, pstmt);
			}
		}
		
		/**
		 * 根据projectid查询项目信息
		 * @param projectid
		 * @return
		 */
		public Project queryByProjectid(String projectid) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			Project pro = new Project();
			try{
				conn = JdbcUtil.getConnection();
				String sql = " select * from project where projectid=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, projectid);
				rs = pstmt.executeQuery();
				if(rs.next()){
					pro.setProjectid(rs.getString("projectid"));
					pro.setName(rs.getString("name"));
					pro.setInstitution(rs.getString("institution"));
					pro.setLevel(rs.getString("level"));
					pro.setFunds(rs.getString("funds"));
					pro.setManager(rs.getString("manager"));
					pro.setPhonenum(rs.getString("phonenum"));
					
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				JdbcUtil.close(conn, pstmt, rs);
			}
			return pro;
		}
		/**
		 * 添加项目
		 */
		public void addProject(Project pro) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = JdbcUtil.getConnection();
				String sql = " insert into project values (?,?,?,?,?,?,?)";
				pstmt = JdbcUtil.getPreparedStatement(conn, sql);
				pstmt.setString(1, pro.getProjectid());
				pstmt.setString(2, pro.getName());
				pstmt.setString(3, pro.getInstitution());
				pstmt.setString(4, pro.getLevel());
				pstmt.setString(5, pro.getFunds());
			    pstmt.setString(6, pro.getManager());
				pstmt.setString(7, pro.getPhonenum());

				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				JdbcUtil.close(conn, pstmt);
			}
			
		}
		
		/**
		 * 获取信息条数
		 */
		public int getCount() {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int count = 0;
			try {
				conn = JdbcUtil.getConnection();
				String sql = " select count(*) count from project";
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
		public List<Project> selectProject(int offset,String select,String neirong) {
			List<Project> proList = new ArrayList<Project>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try{
				conn = JdbcUtil.getConnection();
				String sql = " select * from project where "+select+"='"+neirong+"'limit ?,?";
				pstmt = conn.prepareStatement(sql);

				pstmt.setInt(1, offset);
				pstmt.setInt(2, Constants.MAX_PAGE_COUNT);
				rs = pstmt.executeQuery();
				while(rs.next()){
					Project pro = new Project();
					pro.setProjectid(rs.getString("projectid"));
					pro.setName(rs.getString("name"));
					pro.setInstitution(rs.getString("institution"));
					pro.setLevel(rs.getString("level"));
					pro.setFunds(rs.getString("funds"));
					pro.setManager(rs.getString("manager"));
					pro.setPhonenum(rs.getString("phonenum"));
					
					proList.add(pro);
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				JdbcUtil.close(conn, pstmt, rs);
			}
			return proList;
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
				String sql = " select count(*) from project where "+select+"='"+neirong+"' ";
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

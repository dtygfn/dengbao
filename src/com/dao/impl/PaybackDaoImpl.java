package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Payback;
import com.constants.Constants;
import com.dao.PaybackDao;
import com.util.JdbcUtil;
/****
 * 回款Dao层实现
 * @author 12149
 *
 */

public class PaybackDaoImpl implements PaybackDao{

	@Override
	/***
	 * 获取回款信息列表
	 */
	public List<Payback> getPaybackList(int offset) {
		List<Payback> payList = new ArrayList<Payback>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql = " select * from payback limit ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, offset);
			pstmt.setInt(2, Constants.MAX_PAGE_COUNT);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Payback pay = new Payback();
				pay.setPayid(rs.getString("payid"));
				pay.setName(rs.getString("name"));
				pay.setMoney(rs.getString("money")+"元");
				pay.setAmount(rs.getString("amount")+"元");
				pay.setInvoice(rs.getString("invoice"));
				pay.setBilldate(rs.getString("billdate"));
				pay.setOfficer(rs.getString("officer"));
				
				payList.add(pay);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt, rs);
		}
		return payList;
	}

	@Override
	/**
	 * 删除回款信息
	 */
	public void deletePayback(String payid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = " delete from payback where payid=?";
			pstmt = JdbcUtil.getPreparedStatement(conn, sql);
			pstmt.setString(1,payid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt);
		}
	}

	@Override
	/**
	 * 更新回款信息列表
	 */
	public void updatePayback(Payback pay, String payid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "update payback set name=?,money=?,amount=?,invoice=?,billdate=?,officer=? where payid="+"'"+payid+"'";
			
			pstmt = JdbcUtil.getPreparedStatement(conn, sql);
			pstmt.setString(1, pay.getName());
			pstmt.setInt(2, Integer.parseInt(pay.getMoney().substring(0, pay.getMoney().indexOf("元"))));
			pstmt.setInt(3, Integer.parseInt(pay.getAmount().substring(0,pay.getAmount().indexOf("元"))));
			pstmt.setString(4, pay.getInvoice());
			pstmt.setString(5, pay.getBilldate());
			pstmt.setString(6,pay.getOfficer());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt);
		}

		
	}

	@Override
	/**
	 * 根据payid查询回款信息
	 */
	public Payback queryByPayid(String payid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Payback pay = new Payback();
		try{
			conn = JdbcUtil.getConnection();
			String sql = " select * from payback where payid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, payid);
			rs = pstmt.executeQuery();
			if(rs.next()){
				pay.setPayid(payid);
				pay.setName(rs.getString("name"));
				pay.setMoney(rs.getString("money")+"元");
				pay.setAmount(rs.getString("amount")+"元");
				pay.setInvoice(rs.getString("invoice"));
				pay.setBilldate(rs.getString("billdate"));
				pay.setOfficer(rs.getString("officer"));
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt, rs);
		}
		return pay;

	}

	@Override
	/****
	 * 添加回款信息
	 */
	public void addPayback(Payback pay) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = " insert into payback values(?,?,?,?,?,?,?)";
			pstmt = JdbcUtil.getPreparedStatement(conn, sql);
			pstmt.setString(1, pay.getPayid());
			pstmt.setString(2, pay.getName());
			pstmt.setInt(3, Integer.parseInt(pay.getMoney().substring(0, pay.getMoney().indexOf("元"))));
			pstmt.setInt(4, Integer.parseInt(pay.getAmount().substring(0,pay.getAmount().indexOf("元"))));
			pstmt.setString(5, pay.getInvoice());
			pstmt.setString(6, pay.getBilldate());
			pstmt.setString(7, pay.getOfficer());
		
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt);
		}
		
	}

	@Override
	/***
	 * 获取回款信息条数
	 */
	public int getCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = JdbcUtil.getConnection();
			String sql = " select count(*) count from payback";
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
	/***
	 * 根据条件查询回款信息
	 */
	public List<Payback> selectPayback(int offset, String select, String neirong) {
		List<Payback> payList = new ArrayList<Payback>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql = " select * from payback where "+select+"='"+neirong+"'limit ?,?";
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setInt(1, offset);
			pstmt.setInt(2, Constants.MAX_PAGE_COUNT);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Payback pay = new Payback();
				
				pay.setPayid(rs.getString("payid"));
				pay.setName(rs.getString("name"));
				pay.setMoney(rs.getString("money")+"元");
				pay.setAmount(rs.getString("amount")+"元");
				pay.setInvoice(rs.getString("invoice"));
				pay.setBilldate(rs.getString("billdate"));
				pay.setOfficer(rs.getString("officer"));
				
				payList.add(pay);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt, rs);
		}
		return payList;
	}

	@Override
	/**
	 * 获取根据条件查询后的回款信息个数
	 */
	public int getSelectCount(String select, String neirong) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = JdbcUtil.getConnection();
			String sql = " select count(*) from payback where "+select+"='"+neirong+"' ";
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

package com.dao;

import java.util.List;

import com.bean.Payback;

/****
 * 回款类管理接口
 * @author 12149
 *
 */
public interface PaybackDao {
	public List<Payback> getPaybackList(int offset);

	public void deletePayback(String payid);

	public void updatePayback(Payback pay,String payid);
	
	public Payback queryByPayid(String payid);
	
	public void addPayback(Payback pay);
	
	public int getCount();

	List<Payback> selectPayback(int offset, String select, String neirong);

	int getSelectCount(String select, String neirong);


}

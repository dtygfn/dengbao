package com.dao;


import java.util.List;

import com.bean.User;



public interface UserDao {
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username,String password);
	
	public List<User> getUserList(int offset);
		
	public void deleteUser(String username);

	public void updateUser(User user,String username);
	
	public User queryByUsername(String username);
	
	public void addUser(User user);
	

	List<User> selectUser(int offset, String select, String neirong);

	int getSelectCount(String select, String neirong);
	
	public int getCount();


}

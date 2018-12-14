package com.dao;

import java.util.List;

import com.bean.Task;

public interface TaskDao {
	List<Task> getTaskList(int offset);
	
	List<Task> getEarTaskList(int offset,String username);
	
	List<Task> getMidTaskList(int offset,String username);
	
	List<Task> getLateTaskList(int offset,String username);

	void deleteTask(String projectid);

	void updateTask(Task task,String projectid);
	
	public Task queryByProjectid(String projectid);

	void addTask(Task task);
	
	int getCount();
	
	int getEarCount(String username);
	
	int getMidCount(String username);
	
	int getLateCount(String username);
	
	List<Task> selectTask(int offset, String select, String neirong);

	int getSelectCount(String select, String neirong);

}

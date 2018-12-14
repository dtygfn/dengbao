package com.dao;
/***
 * 项目管理类接口
 */

import java.util.List;

import com.bean.Project;


public interface ProjectDao {
	
	List<Project> getProjectList(int offset);

	void deleteProject(String projectid);

	void updateProject(Project pro,String projectid);
	
	public Project queryByProjectid(String projectid);

	void addProject(Project pro);
	
	int getCount();
	
	List<Project> selectProject(int offset, String select, String neirong);

	int getSelectCount(String select, String neirong);

}

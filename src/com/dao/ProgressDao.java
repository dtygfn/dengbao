package com.dao;

import java.util.List;

import com.bean.Progress;;

public interface ProgressDao {
	List<Progress> getProgressList(int offset);
	
	List<Progress> getEarProgressList(int offset,String username);
	
	List<Progress> getMidProgressList(int offset,String username);
	
	List<Progress> getLateProgressList(int offset,String username);
	
	void deleteProgress(String projectid);

	void updateProgress(Progress progress,String projectid);
	
	void updateEarProgress(Progress progress,String projectid);
	
	void updateMidProgress(Progress progress,String projectid);	
	
	void updateLateProgress(Progress progress,String projectid);	
	public Progress queryByProjectid(String projectid);
	
	public Progress earqueryByProjectid(String projectid);
	
	public Progress midqueryByProjectid(String projectid);
	
	public Progress latequeryByProjectid(String projectid);

	void addProgress(Progress progress);
	
	int getCount();
	
	List<Progress> selectProgress(int offset, String select, String neirong);

	int getSelectCount(String select, String neirong);


}

package com.dao;

import java.util.List;

import com.bean.Person;
/***
 * 员工类管理接口
 * @author 12149
 *
 */
public interface PersonDao {
	public List<Person> getPersonList(int offset);
	
	public void deletePerson(String workerid);

	public void updatePerson(Person pson,String workerid);
	
	public Person queryByWorkerid(String workerid);
	
	public void addPerson(Person pson);
	
	public int getCount();

	List<Person> selectPerson(int offset, String select, String neirong);

	int getSelectCount(String select, String neirong);
    
	

}

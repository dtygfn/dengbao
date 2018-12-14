package com.bean;

public class Person {
	private String workerid;//工号
	
	private String workername;//姓名
	
	private int age;//年龄
	
	private String sex;//性别
	
	private String title;//职称
	
    private String teleno;//电话号
   
    private String email;//邮箱
    
	public String getWorkername() {
		return workername;
	}
	
	public void setWorkername(String name) {
		this.workername = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getTeleno() {
		return teleno;
	}
	
	public void setTeleno(String teleno) {
		this.teleno = teleno;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getWorkerid() {
		return workerid;
	}
	
	public void setWorkerid(String workid) {
		this.workerid = workid;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

}




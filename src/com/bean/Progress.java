package com.bean;

public class Progress {
	
	private String projectid;//项目编号
	
	private String name;//项目名称
	
	private String eartime;//前期开始时间
	
	private String earprogress;//前期进程
		
    private String midtime;//中期开始时间
	
	private String midprogress;//中期进程
	
	private String latetime;//后期开始时间
	
	private String lateprogress;//后期进程
		
	private String progress;//项目进程

	private String endtime;//项目完成时间
	
	private String result;//测评结果

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getProjectid() {
		return projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}

	
	public String getEarprogress() {
		return earprogress;
	}

	public void setEarprogress(String earprogress) {
		this.earprogress = earprogress;
	}

	

	public String getMidprogress() {
		return midprogress;
	}

	public void setMidprogress(String midprogress) {
		this.midprogress = midprogress;
	}

	

	public String getLateprogress() {
		return lateprogress;
	}

	public void setLateprogress(String lateprogress) {
		this.lateprogress = lateprogress;
	}

	

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public String getEartime() {
		return eartime;
	}

	public void setEartime(String eartime) {
		this.eartime = eartime;
	}

	public String getMidtime() {
		return midtime;
	}

	public void setMidtime(String midtime) {
		this.midtime = midtime;
	}

	public String getLatetime() {
		return latetime;
	}

	public void setLatetime(String latetime) {
		this.latetime = latetime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	

}

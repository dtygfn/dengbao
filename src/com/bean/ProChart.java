package com.bean;

public class ProChart {
	
	private String level;//项目等级名称
	
	private int num;//项目等级数目

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	@Override
    public String toString() {
        return "prochart{" +
                "level=" + level +
                ", num='" + num +
                '}';
    }

}

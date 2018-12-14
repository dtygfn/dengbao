package com.bean;

public class Payback{
	
	private String payid;//回款编号
	
	private String name;//项目名称
	
	private String money;//应回金额
	
	private String amount;//已回金额
	
	private String invoice;//是否已开发票
	
	private String billdate;//开票日期
	
	private String officer;//开票人员

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getPayid() {
		return payid;
	}

	public void setPayid(String payid) {
		this.payid = payid;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}


	public String getOfficer() {
		return officer;
	}

	public void setOfficer(String officer) {
		this.officer = officer;
	}

	public String getBilldate() {
		return billdate;
	}

	public void setBilldate(String billdate) {
		this.billdate = billdate;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
}

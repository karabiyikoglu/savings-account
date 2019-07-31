package com.karabiyikoglu.savingsaccount.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.karabiyikoglu.savingsaccount.util.IDGenerator;

public class SavingAccount {

	private String user;
	private Integer id;
	private Date createDate;

	public SavingAccount(String user) {
		this.user		= user;
		this.id 		= IDGenerator.getNewAccountID();
		this.createDate = new Date();
	}
	
	public Integer getId() {
		return id;
	}

	public String getUser() {
		return user;
	}
	public Date getCreateDate() {
		return createDate;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		DateFormat dtf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
		str.append("user : ").append(user).append(", id : ").append(id).append(", create date : ").append(dtf.format(createDate));
		return str.toString();
	}
}

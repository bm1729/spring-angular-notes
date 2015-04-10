package com.benmumford.web.ui;

import org.joda.time.DateTime;

public class BaseEntityUI {
    
	private int id;
	private DateTime createDate;
	private DateTime modifiedDate;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public DateTime getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(DateTime createDate) {
		this.createDate = createDate;
	}
	
	public DateTime getModifiedDate() {
		return modifiedDate;
	}
	
	public void setModifiedDate(DateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}

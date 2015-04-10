package com.benmumford.web.ui;

import java.util.List;

public class NoteUI extends BaseEntityUI {
	
	private String title;
	private String businessContent;
	private String technicalContent;
	private List<TagUI> tags;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getBusinessContent() {
		return businessContent;
	}
	
	public void setBusinessContent(String businessContent) {
		this.businessContent = businessContent;
	}
	
	public String getTechnicalContent() {
		return technicalContent;
	}
	
	public void setTechnicalContent(String technicalContent) {
		this.technicalContent = technicalContent;
	}
	
	public List<TagUI> getTags() {
		return tags;
	}
	
	public void setTags(List<TagUI> tags) {
		this.tags = tags;
	}
}

package com.benmumford.web.ui;

import java.util.List;

public class TagUI extends BaseEntityUI {
    
	private String name;
	private List<NoteUI> notes;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<NoteUI> getNotes() {
		return notes;
	}
	
	public void setNotes(List<NoteUI> notes) {
		this.notes = notes;
	}
}

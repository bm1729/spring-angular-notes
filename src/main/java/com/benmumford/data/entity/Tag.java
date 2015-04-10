package com.benmumford.data.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tag")
public class Tag extends BaseEntity {

	@Column(unique=true)
	private String name;
	
	@JoinTable(name = "note_tag", joinColumns = {
			@JoinColumn(name = "tag_id", referencedColumnName = "id")
	},
	inverseJoinColumns = {
			@JoinColumn(name = "note_id", referencedColumnName = "id")
	})
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Note> notes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
}

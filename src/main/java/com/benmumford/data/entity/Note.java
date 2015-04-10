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
@Table(name="note")
public class Note extends BaseEntity {
	
	@Column(unique=true)
	private String title;
	private String businessContent;
	private String technicalContent;
	
	@JoinTable(name = "note_tag", joinColumns = {
			@JoinColumn(name = "note_id", referencedColumnName = "id")
	},
	inverseJoinColumns = {
			@JoinColumn(name = "tag_id", referencedColumnName = "id")
	})
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Tag> tags;
	
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

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
}

package com.benmumford.data.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@MappedSuperclass
public abstract class BaseEntity {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime createDate;
	
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime modifiedDate;

	public int getId() {
		return id;
	}
	
	public DateTime getCreateDate() {
		return createDate;
	}

	public DateTime getModifiedDate() {
		return modifiedDate;
	}

	@PreUpdate
	@PrePersist
	public void updateTimeStamp() {
		modifiedDate = new DateTime();
		if (createDate == null) {
			createDate = new DateTime();
		}
	}

	@Override
    public String toString() {
    	return new StringBuilder(getClass().getSimpleName())
    		.append(":")
    		.append(getId())
    		.toString();
    }
}

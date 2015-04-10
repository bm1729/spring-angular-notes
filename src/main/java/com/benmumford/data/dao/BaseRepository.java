package com.benmumford.data.dao;

import org.springframework.data.repository.CrudRepository;

import com.benmumford.data.entity.BaseEntity;

public interface BaseRepository<E extends BaseEntity> extends CrudRepository<E, Integer>{
	
}

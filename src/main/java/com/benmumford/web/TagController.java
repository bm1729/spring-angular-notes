package com.benmumford.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benmumford.data.dao.TagRepository;
import com.benmumford.data.entity.Tag;

@RestController
public class TagController {
	
	@Autowired private TagRepository tagRepository;

	@RequestMapping("/tags")
	public Iterable<Tag> getTags() {
		return tagRepository.findAll();
	}

	@RequestMapping("/tag/{id}")
	public Tag getTag(@PathVariable("id") Integer id) {
		return tagRepository.findOne(id);
	}
}

package com.benmumford.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benmumford.data.dao.TagRepository;
import com.benmumford.web.ui.TagConverter;
import com.benmumford.web.ui.TagUI;
import com.google.common.collect.Lists;

@RestController
public class TagController {
	
	private TagRepository tagRepository;
	private TagConverter tagConverter;

	@Autowired
	public TagController(TagRepository tagRepository, TagConverter tagConverter) {
		this.tagRepository = tagRepository;
		this.tagConverter = tagConverter;
	}

	@RequestMapping("/tags")
	public Iterable<TagUI> getTags() {
		return Lists.transform(Lists.newArrayList(tagRepository.findAll()), tagConverter);
	}

	@RequestMapping("/tag/{id}")
	public TagUI getTag(@PathVariable("id") Integer id) {
		return tagConverter.apply(tagRepository.findOne(id));
	}
}

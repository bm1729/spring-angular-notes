package com.benmumford.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benmumford.data.dao.NoteRepository;
import com.benmumford.data.dao.TagRepository;
import com.benmumford.data.entity.Note;
import com.benmumford.data.entity.Tag;
import com.benmumford.web.core.ResourceNotFoundException;
import com.benmumford.web.ui.TagConverter;
import com.benmumford.web.ui.TagUI;
import com.google.common.collect.Lists;

@RestController
public class TagController {

	private NoteRepository noteRepository;
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
	
	@RequestMapping("/tags/note/{id}")
	public List<TagUI> getTagsByNote(@PathVariable("id") Integer id) {
		Note note = noteRepository.findOne(id);
		if (note == null) {
			throw new ResourceNotFoundException("Cannot find note with id: " + id);
		}
		return Lists.transform(Lists.newArrayList(note.getTags()), tagConverter);
	}

	@RequestMapping("/tag/{id}")
	public TagUI getTag(@PathVariable("id") Integer id) {
		Tag tag = tagRepository.findOne(id);
		if (tag == null) {
			throw new ResourceNotFoundException("Cannot find tag with id: " + id);
		}
		return tagConverter.apply(tag);
	}
}

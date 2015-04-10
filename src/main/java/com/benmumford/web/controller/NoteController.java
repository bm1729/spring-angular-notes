package com.benmumford.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benmumford.data.dao.NoteRepository;
import com.benmumford.data.dao.TagRepository;
import com.benmumford.web.ui.NoteConverter;
import com.benmumford.web.ui.NoteUI;
import com.google.common.collect.Lists;

@RestController
public class NoteController {

	@Autowired private TagRepository tagRepository;
	@Autowired private NoteRepository noteRepository;
	@Autowired private NoteConverter noteConverter;

	@RequestMapping("/notes")
	public List<NoteUI> getNotes() {
		return Lists.transform(Lists.newArrayList(noteRepository.findAll()), noteConverter);
	}
	
	@RequestMapping("/notes/tag/{id}")
	public List<NoteUI> getNotesByTag(@PathVariable("id") Integer id) {
		return Lists.transform(Lists.newArrayList(tagRepository.findOne(id).getNotes()), noteConverter);
	}

	@RequestMapping("/note/{id}")
	public NoteUI getNote(@PathVariable("id") Integer id) {
		return noteConverter.apply(noteRepository.findOne(id));
	}
}

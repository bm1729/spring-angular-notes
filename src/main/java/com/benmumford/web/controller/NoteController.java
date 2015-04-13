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
import com.benmumford.web.ui.NoteConverter;
import com.benmumford.web.ui.NoteUI;
import com.google.common.collect.Lists;

@RestController
public class NoteController {

	private TagRepository tagRepository;
	private NoteRepository noteRepository;
	private NoteConverter noteConverter;
	
	@Autowired
	public NoteController(TagRepository tagRepository, NoteRepository noteRepository, NoteConverter noteConverter) {
		this.tagRepository = tagRepository;
		this.noteRepository = noteRepository;
		this.noteConverter = noteConverter;
	}

	@RequestMapping("/notes")
	public List<NoteUI> getNotes() {
		return Lists.transform(Lists.newArrayList(noteRepository.findAll()), noteConverter);
	}
	
	@RequestMapping("/notes/tag/{id}")
	public List<NoteUI> getNotesByTag(@PathVariable("id") Integer id) {
		Tag tag = tagRepository.findOne(id);
		if (tag == null) {
			throw new ResourceNotFoundException("Cannot find tag with id: " + id);
		}
		return Lists.transform(Lists.newArrayList(tag.getNotes()), noteConverter);
	}

	@RequestMapping("/note/{id}")
	public NoteUI getNote(@PathVariable("id") Integer id) {
		Note note = noteRepository.findOne(id);
		if (note == null) {
			throw new ResourceNotFoundException("Cannot find note with id: " + id);
		}
		return noteConverter.apply(note);
	}
}

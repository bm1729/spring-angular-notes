package com.benmumford.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benmumford.data.dao.NoteRepository;
import com.benmumford.data.entity.Note;

@RestController
public class NoteController {
	
	@Autowired private NoteRepository noteRepository;

	@RequestMapping("/notes")
	public Iterable<Note> getNotes() {
		return noteRepository.findAll();
	}

	@RequestMapping("/note/{id}")
	public Note getNote(@PathVariable("id") Integer id) {
		return noteRepository.findOne(id);
	}
}

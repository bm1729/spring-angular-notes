package com.benmumford.web.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benmumford.data.entity.Note;
import com.google.common.collect.Lists;

@Service
public class NoteConverter extends BaseConverter<Note, NoteUI> {
	
	@Autowired private TagConverter tagConverter;

	@Override
	protected NoteUI createEntityUI() {
		return new NoteUI();
	}

	@Override
	protected void internalConvert(Note e, NoteUI ui) {
		ui.setBusinessContent(e.getBusinessContent());
		ui.setTechnicalContent(e.getTechnicalContent());
		ui.setTitle(e.getTitle());
		ui.setTags(Lists.transform(e.getTags(), tagConverter));
	}
}

package com.benmumford.web.ui;

import javax.annotation.Nullable;

import org.springframework.stereotype.Service;

import com.benmumford.data.entity.Note;
import com.benmumford.data.entity.Tag;
import com.google.common.base.Function;
import com.google.common.collect.Lists;

@Service
public class TagConverter extends BaseConverter<Tag, TagUI> {

	@Override
	protected TagUI createEntityUI() {
		return new TagUI();
	}

	@Override
	protected void internalConvert(Tag e, TagUI ui) {
		ui.setName(e.getName());
		ui.setNotes(Lists.transform(e.getNotes(), new Function<Note, NoteUI>() {

			@Override
			public NoteUI apply(@Nullable Note note) {
				NoteUI noteUI = new NoteUI();
				noteUI.setId(note.getId());
				noteUI.setTitle(note.getTitle());
				
				return noteUI;
			}
		}));
	}
}

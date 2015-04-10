package com.benmumford.web.ui;

import javax.annotation.Nullable;

import org.springframework.stereotype.Service;

import com.benmumford.data.entity.Note;
import com.benmumford.data.entity.Tag;
import com.google.common.base.Function;
import com.google.common.collect.Lists;

@Service
public class NoteConverter extends BaseConverter<Note, NoteUI> {
	
	private static class TagConverter implements Function<Tag, TagUI> {

		@Override
		public TagUI apply(@Nullable Tag tag) {
			TagUI tagUI = new TagUI();
			tagUI.setName(tag.getName());
			tagUI.setId(tag.getId());
			return tagUI;
		}
	};
	private static TagConverter TAG_CONVERTER = new TagConverter();

	@Override
	protected NoteUI createEntityUI() {
		return new NoteUI();
	}

	@Override
	protected void internalConvert(Note e, NoteUI ui) {
		ui.setBusinessContent(e.getBusinessContent());
		ui.setTechnicalContent(e.getTechnicalContent());
		ui.setTitle(e.getTitle());
		ui.setTags(Lists.transform(e.getTags(), TAG_CONVERTER));
	}
}

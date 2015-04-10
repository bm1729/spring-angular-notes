package com.benmumford.web.ui;

import org.springframework.stereotype.Service;

import com.benmumford.data.entity.Tag;

@Service
public class TagConverter extends BaseConverter<Tag, TagUI> {

	@Override
	protected TagUI createEntityUI() {
		return new TagUI();
	}

	@Override
	protected void internalConvert(Tag e, TagUI ui) {
		ui.setName(e.getName());
	}
}

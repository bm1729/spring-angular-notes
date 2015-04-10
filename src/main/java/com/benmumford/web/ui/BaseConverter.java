package com.benmumford.web.ui;

import javax.annotation.Nullable;

import com.benmumford.data.entity.BaseEntity;
import com.google.common.base.Function;

public abstract class BaseConverter<E extends BaseEntity, UI extends BaseEntityUI> implements Function<E, UI> {
	
	@Override
	public UI apply(@Nullable E e) {
		UI ui = createEntityUI();
		ui.setCreateDate(e.getCreateDate());
		ui.setModifiedDate(e.getModifiedDate());
		ui.setId(e.getId());
		
		internalConvert(e, ui);
		
		return ui;
	}

	protected abstract UI createEntityUI();
	
	protected abstract void internalConvert(E e, UI ui);
}

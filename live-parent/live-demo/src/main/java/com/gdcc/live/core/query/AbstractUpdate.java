package com.gdcc.live.core.query;

import com.gdcc.live.core.context.AppContext;


public abstract class AbstractUpdate<T extends AbstractUpdate<T>> {

	protected transient AppContext appContext;

	protected AbstractUpdate(AppContext appContext) {
		this.appContext = appContext;
	}

	public abstract long execute();
}

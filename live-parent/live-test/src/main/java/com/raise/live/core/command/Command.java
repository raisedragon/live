package com.raise.live.core.command;

import com.raise.live.core.command.context.CommandContext;

public interface Command<T> {
	T execute(CommandContext commandContext);
}

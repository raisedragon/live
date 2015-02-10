package com.raise.live.core.command.context;

import com.raise.live.core.cfg.LiveConfiguration;
import com.raise.live.core.command.Command;
import com.raise.live.core.manager.Manager;

/**
 * 命令上下文
 * @author longsheng.wang
 */
public class CommandContext {
	protected Command<?> command;
	protected LiveConfiguration configuration;

	public CommandContext(Command<?> command, LiveConfiguration configuration) {
		this.command = command;
		this.configuration = configuration;
	}

	public <T extends Manager> T getManager(Class<T> managerClass) {
		return configuration.getApplicationContext().getBean(managerClass);
	}

	
	
	//getter and setter
	public Command<?> getCommand() {
		return command;
	}

	public LiveConfiguration getConfiguration() {
		return configuration;
	}
	
	
}

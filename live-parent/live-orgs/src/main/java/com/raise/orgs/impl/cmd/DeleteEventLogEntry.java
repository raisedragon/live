package com.raise.orgs.impl.cmd;

import com.raise.orgs.impl.interceptor.Command;
import com.raise.orgs.impl.interceptor.CommandContext;

/**
 * @author Joram Barrez
 */
public class DeleteEventLogEntry implements Command<Void> {
	
	protected long logNr;
	
	public DeleteEventLogEntry(long logNr) {
		this.logNr = logNr;
	}
	
	@Override
	public Void execute(CommandContext commandContext) {
		commandContext.getEventLogEntryEntityManager().deleteEventLogEntry(logNr);
		return null;
	}

}

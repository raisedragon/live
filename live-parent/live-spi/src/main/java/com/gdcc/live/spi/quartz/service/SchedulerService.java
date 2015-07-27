package com.gdcc.live.spi.quartz.service;

import java.util.List;




import com.gdcc.live.spi.quartz.command.AddJobCommand;
import com.gdcc.live.spi.quartz.command.AddTriggerCommand;
import com.gdcc.live.spi.quartz.command.GetAllSchedulerCommand;

public interface SchedulerService {
	public List<com.gdcc.live.spi.quartz.command.Scheduler> getAllSchedulers(GetAllSchedulerCommand request) ;
	
	public void addJob(AddJobCommand addJobCommand);
	
	
	public void addTrigger(AddTriggerCommand addTriggerCommand);
}

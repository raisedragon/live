package com.gdcc.live.quartz.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextLoader;

import com.gdcc.live.core.utils.AppUtil;
import com.gdcc.live.quartz.MethodInvokingJobDetailBuilder;
import com.gdcc.live.spi.exception.SpiException;
import com.gdcc.live.spi.quartz.command.AddJobCommand;
import com.gdcc.live.spi.quartz.command.AddTriggerCommand;
import com.gdcc.live.spi.quartz.command.GetAllSchedulerCommand;
import com.gdcc.live.spi.quartz.service.SchedulerService;

@Service
public class SchedulerServiceImpl implements SchedulerService {
	@Autowired
	private Scheduler scheduler;

	@Override
	public List<com.gdcc.live.spi.quartz.command.Scheduler> getAllSchedulers(GetAllSchedulerCommand request) {

		try {
			List<com.gdcc.live.spi.quartz.command.Scheduler> spiSchs = new ArrayList<com.gdcc.live.spi.quartz.command.Scheduler>();
			com.gdcc.live.spi.quartz.command.Scheduler spiSch = new com.gdcc.live.spi.quartz.command.Scheduler();
			BeanUtils.copyProperties(spiSch, scheduler);
			spiSchs.add(spiSch);
			return spiSchs;
		} catch (Exception e) {
			throw new SpiException(e);
		}
	}

	@Override
	public void addJob(AddJobCommand addJobCommand) {
		try {
			  MethodInvokingJobDetailBuilder jobBuilder = new MethodInvokingJobDetailBuilder();
              jobBuilder.withTargetClass(addJobCommand.getTargetClass())
              	.withTargetMethod(addJobCommand.getTargetMethod())
              	.withName(addJobCommand.getName())
              	.withGroup(addJobCommand.getGroup())
              	.withDescription(addJobCommand.getDescription())
              	.withConcurrent(addJobCommand.isConcurrent());
              
              JobDetail jobDetail = jobBuilder.build();

              scheduler.addJob(jobDetail, addJobCommand.isReplace(), addJobCommand.isStoreNonDurableWhileAwaitingScheduling());
		} catch (Exception e) {
			throw new SpiException(e);
		}
	}

	@Override
	public void addTrigger(AddTriggerCommand addTriggerCommand) {
		try {
			JobDetail jobDetail = scheduler.getJobDetail(new JobKey(addTriggerCommand.getJobName(), addTriggerCommand.getJobGroup()));
			TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
			Trigger trigger = triggerBuilder
					.forJob(addTriggerCommand.getJobName(), addTriggerCommand.getJobGroup())
					.withSchedule(CronScheduleBuilder.cronSchedule(addTriggerCommand.getCronExpression()))
					.withIdentity(addTriggerCommand.getName(), addTriggerCommand.getGroup())
					.withDescription(addTriggerCommand.getDescription())
					.build();
			Set<Trigger> triggers = new HashSet<Trigger>();
			triggers.add(trigger);
			scheduler.scheduleJob(jobDetail,triggers,addTriggerCommand.isReplace());
		} catch (Exception e) {
			throw new SpiException(e);
		}
	}

}

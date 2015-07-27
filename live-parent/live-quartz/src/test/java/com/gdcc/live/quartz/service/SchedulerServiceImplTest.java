package com.gdcc.live.quartz.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.gdcc.live.spi.quartz.command.AddJobCommand;
import com.gdcc.live.spi.quartz.command.AddTriggerCommand;
import com.gdcc.live.spi.quartz.command.GetAllSchedulerCommand;
import com.gdcc.live.spi.quartz.command.Scheduler;
import com.gdcc.live.spi.quartz.service.SchedulerService;



@ContextConfiguration({ "classpath:/conf/spring/context.xml" })
//@ActiveProfiles({ "test" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class SchedulerServiceImplTest {

	@Autowired
	private SchedulerService schedulerService;
	
//	@Test
	public void testGetAllSchedulers() {
		
		GetAllSchedulerCommand cmd = new GetAllSchedulerCommand();
		List<Scheduler> list = schedulerService.getAllSchedulers(cmd);
		assertNotNull(list);
	}
	
//	@Test
//	@Rollback(false)
	public void testAddJob(){
		AddJobCommand  cmd = new AddJobCommand();
		cmd.setDescription("test");
		cmd.setName("test");
		cmd.setGroup("test");
		cmd.setTargetMethod("testMethod");
		cmd.setTargetClass(TestBean.class);
		cmd.setReplace(true);
		schedulerService.addJob(cmd);
	}
	
	
	@Test
	@Rollback(false)
	public void testAddTrigger(){
		AddTriggerCommand cmd = new AddTriggerCommand();
		cmd.setDescription("test");
		cmd.setName("test");
		cmd.setGroup("test");
		cmd.setJobGroup("test");
		cmd.setJobName("test");
		cmd.setReplace(true);
		cmd.setCronExpression("15 0/2 * * * ?");
		schedulerService.addTrigger(cmd);
	}

}

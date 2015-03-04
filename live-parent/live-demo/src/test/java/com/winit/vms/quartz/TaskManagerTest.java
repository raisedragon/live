package com.winit.vms.quartz;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.quartz.SchedulerException;

import com.winit.vms.system.BaseTest;


/**
 * <定时任务管理单元测试类>
 * 
 * @version 
 * <pre>
 * Author	Version		Date		Changes
 * jianfa.zhuang 	1.0  		2015-2-5 	Created
 *
 * </pre>
 * @since 1.
 */
@Ignore
public class TaskManagerTest extends BaseTest{
    
    @Resource
    private TaskManager taskManager;
    
    @Before
    public void addJob() throws Exception{
        taskManager.init();
    }
    @Test
    public void getAllJob() throws SchedulerException{
        taskManager.getAllJob();
    }
    
    @Test
    public void getRunningJob() throws SchedulerException{
        taskManager.getRunningJob();
    }
}

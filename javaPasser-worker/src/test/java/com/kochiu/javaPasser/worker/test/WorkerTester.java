package com.kochiu.javaPasser.worker.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.kochiu.se.core.quartz.component.QuartzManager;
import com.kochiu.se.core.tbschedule.component.ScheduleManager;
import com.kochiu.se.unit.test.BaseUnTransactionalTest;

public class WorkerTester extends BaseUnTransactionalTest {

    @Autowired(required = false)
    private QuartzManager quartzManager;

    @Autowired(required = false)
    private ScheduleManager scheduleManager;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testQuartz() {
        String schedName = "demo20Scheduler";
        String jobName = "测试订单统计任务20";
        String jobGroup = "测试订单任务组20";
        String jobClassName = "demoTestJob";
        String description = "测试统计每日的订单总量并且分组20";
        boolean isRecovery = false;
        String triggerName = "测试每分钟执行的订单统计20";
        String triggerGroup = "测试订单触发器组20";
        boolean isCronTrigger = true;
        String expression = "30 * * * * ?";
        Map<String, String> extraInfo = new HashMap<String, String>();
        extraInfo.put("extra", "demo");
        quartzManager.getAllJobs();
        quartzManager.saveOrUpdateJob(schedName, jobName, jobGroup, jobClassName, description, isRecovery, triggerName, triggerGroup, isCronTrigger,
                expression, null, null, extraInfo);
        Assert.assertTrue(true);
    }

	/*@Test
    public void testTbschedule() {
		String scheduleName = "fenrunScheduler";
		String taskName = "代理商销售返点日结任务";
		String taskBeanName = "agentDailySettleTask";
		String strategyName = "代理商销售返点日结任务策略器";
		String extraInfo = null;
		scheduleManager.saveOrUpdateTask(scheduleName, taskName, taskBeanName, strategyName, extraInfo);
		Assert.assertTrue(true);
	}*/

}
package com.sztx.javaPasser.worker.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import com.sztx.se.core.quartz.job.BaseJob;


/**
 * 
 * @author zhihongp
 *
 */
@Component("demoTestJob")
public class DemoTestJob extends BaseJob {

	@Override
	public Object executeJob(JobExecutionContext ctx) throws JobExecutionException {
		System.out.println("DemoTestJob executeJob");
		return "Test demoTestJob";
	}

}

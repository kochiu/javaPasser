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
@Component("countOrderJob")
public class CountOrderJob extends BaseJob {

	@Override
	public Object executeJob(JobExecutionContext ctx) throws JobExecutionException {
		System.out.println("CountOrderJob executeJob");
		return "Test countOrderJob";
	}

}

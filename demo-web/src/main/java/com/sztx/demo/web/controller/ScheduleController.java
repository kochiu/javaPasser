package com.sztx.demo.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sztx.se.common.domain.Result;
import com.sztx.se.common.domain.ResultCode;
import com.sztx.se.common.util.validate.ValidateUtil;
import com.sztx.se.core.tbschedule.component.ScheduleManager;
import com.sztx.se.web.controller.BaseController;
@RequestMapping("/schedule")
@Controller
public class ScheduleController extends BaseController {
	
	@Autowired(required = false)
	private ScheduleManager scheduleManager;
	
	@RequestMapping(value = "/addSchedule")
	public Result addSchedule(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		String scheduleName = getStringParameter("scheduleName");
		String taskName = getStringParameter("taskName");
		String taskBeanName = getStringParameter("taskBeanName");
		String strategyName = getStringParameter("strategyName");
		
		ValidateUtil.notBlank(scheduleName,"scheduleName不能为空!");
		ValidateUtil.notBlank(taskName,"taskName不能为空!");
		ValidateUtil.notBlank(taskBeanName,"taskBeanName不能为空!");
		ValidateUtil.notBlank(strategyName,"strategyName不能为空!");
		
		String extraInfo = null;
		scheduleManager.saveOrUpdateTask(scheduleName, taskName, taskBeanName, strategyName, extraInfo);
		Assert.assertTrue(true);
		Result result = new Result(ResultCode.COMMON_SUCCESS, true);
		return result;
	}
	
}

package com.sztx.javaPasser.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sztx.se.common.domain.Result;
import com.sztx.se.common.domain.ResultCode;
import com.sztx.se.core.domain.DdlRoute;
import com.sztx.se.dataaccess.mysql.ddl.DdlConfig;
import com.sztx.se.dataaccess.mysql.ddl.service.DdlRouteService;
import com.sztx.se.web.controller.BaseController;

@RequestMapping("/ddl")
@Controller
public class DdlRouteController extends BaseController {

	/*@Autowired
	private DdlRouteService ddlRouteService;*/

	@RequestMapping("/listDdlConfig")
	public Result listDdlConfig(HttpServletRequest request, HttpServletResponse response, Model model) {
		// 如果是导出请求，只需将需要导出的数据放到request中
		List<DdlConfig> ddlConfigList = new ArrayList<>();
		Result result = new Result(ResultCode.COMMON_SUCCESS, true);
		result.setProperty("ddlConfigList", ddlConfigList);
		return result;
	}

	@RequestMapping("/getDdlRoute")
	public Result getDdlRoute(HttpServletRequest request, HttpServletResponse response, Model model) {
		String table = getStringParameter("table");
		String columnValue = getStringParameter("columnValue");
		DdlRoute ddlRoute = null;
		Result result = new Result(ResultCode.COMMON_SUCCESS, true);
		result.setProperty("ddlRoute", ddlRoute);
		return result;
	}
}

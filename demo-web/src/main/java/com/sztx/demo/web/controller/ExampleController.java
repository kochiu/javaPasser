package com.sztx.demo.web.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.sztx.demo.common.domain.ApplicationConfig;
import com.sztx.demo.core.service.CaptchaService;
import com.sztx.demo.core.service.ImageService;
import com.sztx.demo.core.service.MessageService;
import com.sztx.demo.core.service.RpcTestService;
import com.sztx.demo.core.service.TokenService;
import com.sztx.demo.core.service.UserService;
import com.sztx.demo.dataaccess.domain.UserDO;
import com.sztx.se.common.domain.ContextConstants;
import com.sztx.se.common.domain.Result;
import com.sztx.se.common.domain.ResultCode;
import com.sztx.se.common.util.ImageUtil;
import com.sztx.se.common.util.poi.ExcelResult;
import com.sztx.se.dataaccess.fastdfs.config.ImageInfo;
import com.sztx.se.dataaccess.mysql.ddl.DdlConfig;
import com.sztx.se.web.controller.BaseController;

@RequestMapping("/example")
@Controller
public class ExampleController extends BaseController {

	@Autowired
	private UserService userService;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private CaptchaService captchaService;

	@Autowired
	private ImageService imageService;

	@Autowired
	private MessageService messageService;

	@Autowired
	private RpcTestService rpcTestService;

	@RequestMapping(value = "/testMysql")
	public Result testMysql(HttpServletRequest request, HttpServletResponse response, Model model) {
		String username = getStringParameter("username");
		String password = getStringParameter("password");
		String nick = getStringParameter("nick");
		Integer sex = getIntegerParameter("sex");
		Integer age = getIntegerParameter("age");
		Date birthday = getDateParameter("birthday");
		String address = getStringParameter("address");
		String tel = getStringParameter("tel");
		String email = getStringParameter("email");

		userService.addUser(username, password, nick, sex, age, birthday, address, tel, email, ApplicationConfig.authKey);
		UserDO user = userService.findByUsername(username);
		// 返回页面
		Result result = new Result(ResultCode.COMMON_SUCCESS, true);
		result.setProperty("user", user);
		return result;
	}

	@RequestMapping(value = "/testRedis")
	public Result testRedis(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		String value = tokenService.generateToken(1000l);
		// 返回页面
		Result result = new Result(ResultCode.COMMON_SUCCESS, true);
		result.setProperty("value", value);
		return result;
	}

	@RequestMapping(value = "/testMemcache")
	public Result testMemcache(HttpServletRequest request, HttpServletResponse response, Model model) {
		String username = getStringParameter("username");
		String value = captchaService.generateCaptcha(username, 60);
		// 返回页面
		Result result = new Result(ResultCode.COMMON_SUCCESS, true);
		result.setProperty("value", value);
		return result;
	}

	@RequestMapping(value = "/testFastdfs")
	public Result testFastdfs(HttpServletRequest request, HttpServletResponse response, Model model) {
		String filePath = getStringParameter("filePath");
		Map<String, String> extraInfo = new HashMap<String, String>();
		extraInfo.put("color", "red");
		String fileId = imageService.uploadImage(filePath, "sztx", extraInfo);
		ImageInfo imageInfo = imageService.downloadImage(fileId);
		// 返回页面
		Result result = new Result(ResultCode.COMMON_SUCCESS, true);
		result.setProperty("value", imageInfo);
		return result;
	}

	@RequestMapping(value = "/testRpc", method = RequestMethod.POST)
	public Result testRpc(HttpServletRequest request, Model model) {
		String m = rpcTestService.testRpc();
		// 返回页面
		Result result = new Result(ResultCode.COMMON_SUCCESS, true);
		result.setProperty("value", m);
		return result;
	}

	@RequestMapping(value = "/testMq")
	public Result testMq(HttpServletRequest request, Model model) {
		String message = "{\"itemHost\":\"item.sztx.com\",\"itemId\":\"121345325\",\"abtestKey\":\"A\",\"pageContent\":\"<html>啊啊啊啊</html>\", \"action\":\"add\"}";
		messageService.sendCommentMsg(message);
		// 返回页面
		Result result = new Result(ResultCode.COMMON_SUCCESS, true);
		result.setProperty("message", message);
		return result;
	}

	@RequestMapping(value = "/testImage")
	public Result testImage(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		String imagePath = getStringParameter("imagePath");
		String newImagePath = getStringParameter("newImagePath");
		Integer width = getIntegerParameter("width");
		Integer height = getIntegerParameter("height");
		boolean value = ImageUtil.zoomImage(imagePath, newImagePath, width, height, 30);
		// 返回页面
		Result result = new Result(ResultCode.COMMON_SUCCESS, true);
		result.setProperty("value", value);
		return result;
	}

	@RequestMapping(value = "/testImportExcel")
	public Result testImportExcel(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		MultipartFile multipartFile = getMultipartFile(request, "excelFile");
		InputStream inputStream = multipartFile.getInputStream();
		String file = multipartFile.getOriginalFilename();
		ExcelResult excelResult = userService.importUser(file, inputStream);

		// 返回页面
		Result result = null;

		if (excelResult.isSuccess()) {
			result = new Result(ResultCode.COMMON_SUCCESS, true);
			result.setProperty("successNum", excelResult.getSuccessNum());
		} else {
			result = new Result(ResultCode.COMMON_BUSINESS_EXCEPTION, false);
			result.setProperty("totalNum", excelResult.getTotalNum());
			result.setProperty("successNum", excelResult.getSuccessNum());
			result.setProperty("failureNum", excelResult.getFailureNum());
		}

		return result;
	}

	@RequestMapping(value = "/testExportExcel")
	public Result testExportExcel(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		//String excelFieldDefinition = "[{\"0\": \"表名\"},{\"1\": \"分表字段\"},{\"2\": \"表个数\"},{\"3\": \"数据库\"},{\"4\": \"数据库个数\"}]";
		String excelFieldDefinition = getStringParameter(ContextConstants.EXPORT_FIELD);
		String file = getStringParameter("file");
		List<DdlConfig> objects = new ArrayList<DdlConfig>();
		DdlConfig ddlConfig1 = new DdlConfig("user", "id", 10, "demo", 2, true);
		DdlConfig ddlConfig2 = new DdlConfig("order", "name", 4, "demo", 2, false);
		DdlConfig ddlConfig3 = new DdlConfig("good", "nick", 12, "demo", 2, true);
		objects.add(ddlConfig1);
		objects.add(ddlConfig2);
		objects.add(ddlConfig3);
		ExcelResult excelResult = excelExport(objects, DdlConfig.class, file, true, excelFieldDefinition, 1, response);

		// 返回页面
		Result result = null;

		if (excelResult.isSuccess()) {
			result = new Result(ResultCode.COMMON_SUCCESS, true);
			result.setProperty("successNum", excelResult.getSuccessNum());
		} else {
			result = new Result(ResultCode.COMMON_BUSINESS_EXCEPTION, false);
			result.setProperty("totalNum", excelResult.getTotalNum());
			result.setProperty("successNum", excelResult.getSuccessNum());
			result.setProperty("failureNum", excelResult.getFailureNum());
		}

		return result;
	}
}

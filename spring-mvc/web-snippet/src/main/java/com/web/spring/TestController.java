package com.web.spring;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController
{
	// 获取系统时间
	@RequestMapping(value = "/time/now", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody String time()
	{
		Date now = new Date();
		return String.valueOf(now.getTime());
	}
}

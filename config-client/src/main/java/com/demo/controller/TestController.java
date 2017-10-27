/**
 * 
 */
package com.demo.controller;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.core.env.Environment;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TestController
 * @Description: 获取属性值
 * @author: liuzijian
 * @date: 2017年10月26日 下午5:28:19
 */
@RestController
@RefreshScope
public class TestController {
	
	@Value("${my.name}")
	String myName;
	
//	@RequestMapping("getName")
	@GetMapping("getName")
	public String getName(){
		return myName;
	}

}

package com.hystrix.demo.controller;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

/**
 * @ClassName: HystrixController
 * @Description: 熔断
 * @author: liuzijian
 * @date: 2017年11月5日 下午6:28:19
 */
@RestController
public class HystrixController {
	
	private static final Random random  = new Random();
	
	@GetMapping("/hello2")
	public String hello2(){
		return new HelloCommand().execute();
	}
	
	private class HelloCommand extends com.netflix.hystrix.HystrixCommand<String>{

		protected HelloCommand() {
			super(HystrixCommandGroupKey.Factory.asKey("HELLOWORLD"),
                    100);
		}

		@Override
		protected String run() throws Exception {
			int i = random.nextInt(200);
			System.out.println(String.format("This method will sleep %d milliseconds", i));
			
			TimeUnit.MILLISECONDS.sleep(i);
			
			return "HELLO WORLD";
		}
		
		@Override
		protected String getFallback() {
			return  "There is somthing wrong...";
		}
		
	}
	
	@GetMapping("/hello")
	@HystrixCommand(fallbackMethod="error",commandProperties={
			@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="100")
	})
	public String hello() throws InterruptedException{
		int i = random.nextInt(200);
		System.out.println(String.format("This method will sleep %d milliseconds", i));
		
		TimeUnit.MILLISECONDS.sleep(i);
		
		return "HELLO WORLD";
	}
	
	public String error(){
		return  "There is somthing wrong...";
	}
}

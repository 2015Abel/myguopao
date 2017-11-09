package com.hystrix.demo;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureDemo {

	public static void main(String[] args) {
		Random random = new Random();
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		Future<String> future = service.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				int sleepTime = random.nextInt(200);
				System.out.println("sleepTimem:"+sleepTime);
				TimeUnit.MILLISECONDS.sleep(sleepTime);
				return "Hello world";
			}
			
		});
		
		String result = null;
		try {
			result = future.get(100, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			result = "Error";
		}
		
		System.out.println(result);
		
		service.shutdown();

	}

}
